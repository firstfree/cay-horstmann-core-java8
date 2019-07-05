package ch10.exercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CH10P06 {

  public static final Map<String, Set<File>> filesByWord = new ConcurrentHashMap<>();

  public static void main(String[] args) throws InterruptedException, IOException {
    ExecutorService executor =
        Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    Set<Path> paths = descendants(Paths.get("."));
    for (Path path : paths) {
      executor.execute(readAndMergeFilesContainingWords(path));
    }

    executor.shutdown();
    executor.awaitTermination(5, TimeUnit.MINUTES);

    System.out.println(getFileCount());
  }

  public static int getFileCount() {
    return filesByWord.keySet().stream()
        .mapToInt(k -> filesByWord.get(k).size())
        .sum();
  }

  public static Runnable readAndMergeFilesContainingWords(Path path) {
    return () -> {
      try {
        String content = new String(Files.readAllBytes(path));
        String[] words = content.split("\\PL+");
        for (String word : words) {
          filesByWord.computeIfAbsent(word, k -> Collections.synchronizedSet(new HashSet<>()))
              .add(path.toFile());
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    };
  }


  public static Set<Path> descendants(Path path) throws IOException {
    return Files.walk(path)
        .filter(Files::isRegularFile)
        .collect(Collectors.toSet());
  }
}
