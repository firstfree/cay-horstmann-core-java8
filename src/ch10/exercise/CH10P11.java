package ch10.exercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CH10P11 {

  public static void main(String[] args) throws InterruptedException {

    BlockingQueue<File> fileQueue = new ArrayBlockingQueue<>(100);
    BlockingQueue<Map<String, Integer>> wordQueue = new ArrayBlockingQueue<>(20);
    int numConsumers = 15;

    ExecutorService executor = Executors.newCachedThreadPool();

    executor.execute(new Producer(fileQueue, numConsumers));

    for (int i = 0; i < numConsumers; ++i) {
      executor.execute(new Consumer(fileQueue, wordQueue));
    }

    executor.shutdown();
    executor.awaitTermination(5, TimeUnit.MINUTES);

    List<Map<String, Integer>> results = new ArrayList<>();
    wordQueue.drainTo(results);

    System.out.println(listBySortingInDescending(merge(results), 10));
  }

  public static List<Entry> listBySortingInDescending(Map<String, Integer> m, int maxSize) {
    return m.entrySet().stream()
        .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
        .limit(maxSize)
        .collect(Collectors.toList());
  }

  public static Map<String, Integer> merge(List<Map<String, Integer>> l) {
    return l.stream()
        .reduce((m1, m2) -> m2.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                Math::addExact,
                () -> new HashMap<>(m1)
            )))
        .orElse(new HashMap<>());
  }

  public static Set<Path> descendants(Path path) throws IOException {
    return Files.walk(path)
        .filter(Files::isRegularFile)
        .collect(Collectors.toSet());
  }

  public static class Producer implements Runnable {

    private BlockingQueue<File> fileQueue;
    private int numConsumers;

    public Producer(BlockingQueue<File> fileQueue, int numConsumers) {
      this.fileQueue = fileQueue;
      this.numConsumers = numConsumers;
    }

    @Override
    public void run() {
      try {
        Set<Path> paths = descendants(Paths.get("."));
        for (Path path : paths) {
          fileQueue.put(path.toFile());
        }

        makeDummy();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    public void makeDummy() throws InterruptedException {
      for (int i = 0; i < numConsumers; ++i) {
        fileQueue.put(new File("dummy"));
      }
    }
  }

  public static class Consumer implements Runnable {

    private BlockingQueue<File> fileQueue;
    private BlockingQueue<Map<String, Integer>> wordQueue;
    private Map<String, Integer> countByWord = new HashMap<>();

    public Consumer(BlockingQueue<File> fileQueue, BlockingQueue<Map<String, Integer>> wordQueue) {
      this.fileQueue = fileQueue;
      this.wordQueue = wordQueue;
    }

    public String[] getWordsInFile(File file) throws IOException {
      return new String(Files.readAllBytes(file.toPath())).split("\\PL+");
    }

    @Override
    public void run() {
      try {
        while (true) {
          File file = fileQueue.take();

          if (file.getName().equals("dummy")) {
            wordQueue.add(countByWord);
            return;
          }

          String[] words = getWordsInFile(file);
          for (String word : words) {
            countByWord.merge(word, 1, Math::addExact);
          }
        }
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
