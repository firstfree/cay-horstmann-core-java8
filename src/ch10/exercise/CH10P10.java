package ch10.exercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CH10P10 {

  public static void main(String[] args) throws InterruptedException {
    BlockingQueue<File> queue = new ArrayBlockingQueue<>(100);
    int numConsumers = 15;

    ExecutorService executor = Executors.newCachedThreadPool();
    executor.execute(new Producer(queue, numConsumers));

    for (int i = 0; i < numConsumers; ++i) {
      executor.execute(new Consumer(queue, "CH10"));
    }

    executor.shutdown();
    executor.awaitTermination(5, TimeUnit.MINUTES);
  }

  public static Set<Path> descendants(Path path) throws IOException {
    return Files.walk(path)
        .filter(Files::isRegularFile)
        .collect(Collectors.toSet());
  }

  public static class Producer implements Runnable {

    private BlockingQueue<File> queue;
    private int consumerCount;

    public Producer(BlockingQueue<File> queue, int consumerCount) {
      this.queue = queue;
      this.consumerCount = consumerCount;
    }

    @Override
    public void run() {
      try {
        Set<Path> paths = descendants(Paths.get("."));
        for (Path path : paths) {
          queue.put(path.toFile());
        }

        makeDummy();
      } catch (IOException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }

    public void makeDummy() throws InterruptedException {
      for (int i = 0; i < consumerCount; ++i) {
          queue.put(new File("dummy"));
      }
    }
  }

  public static class Consumer implements Runnable {

    private BlockingQueue<File> queue;
    private String wordToFind;

    public Consumer(BlockingQueue<File> queue, String wordToFind) {
      this.queue = queue;
      this.wordToFind = wordToFind;
    }

    @Override
    public void run() {
      try {
        while (true) {
          File file = queue.take();

          if (file.getName().contains(wordToFind)) {
            System.out.println(Thread.currentThread().getName() + ": " + file.getName());
          }

          if (file.getName().equals("dummy")) {
            return;
          }
        }
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}
