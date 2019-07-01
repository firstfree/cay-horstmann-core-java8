package ch10.exercise.problem03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFinder {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    ExecutorService executor = Executors.newCachedThreadPool();

    Set<Path> paths = descendants(Paths.get("./java8study"));
    List<Callable<Path>> tasks = new ArrayList<>();
    for (Path path : paths) {
      tasks.add(search(path, "found"));
    }

    Path path = executor.invokeAny(tasks);

    System.out.println(path);

    executor.shutdown();
    executor.awaitTermination(5, TimeUnit.MINUTES);
  }

  public static Callable<Path> search(Path path, String wordToFind) {

    return () -> {
      String contents = new String(Files.readAllBytes(path));
      String[] words = contents.split("\\PL+");

      for (String word : words) {
        if (Thread.currentThread().isInterrupted()) {
          System.out.println(Thread.currentThread().getName() + " status: interrupted");
          break;
        }

        if (wordToFind.equals(word)) {
          System.out.println(path + " - found");
          return path;
        }
      }

      throw new RuntimeException();
    };
  }

  public static Set<Path> descendants(Path path) throws IOException {
    try (Stream<Path> entries = Files.walk(path)) {
      return entries.filter(Files::isRegularFile).collect(Collectors.toSet());
    }
  }
}
