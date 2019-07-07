package ch10.exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

public class CH10P13 {

  public static void main(String[] args)
      throws InterruptedException, IOException, ExecutionException, TimeoutException {
    ExecutorService executor = Executors.newCachedThreadPool();

    ExecutorCompletionService<Map<String, Integer>> executorCompletion =
        new ExecutorCompletionService<>(executor);

    List<Future<Map<String, Integer>>> futures = new ArrayList<>();

    Set<Path> paths = descendants(Paths.get("."));
    for (Path path : paths) {
      futures.add(executorCompletion.submit(countWords(path)));
    }

    Map<String, Integer> mergedResult = Collections.emptyMap();

    for (int i = 0; i < paths.size(); ++i) {
      Future<Map<String, Integer>> future = executorCompletion.take();
      Map<String, Integer> result = future.get(1, TimeUnit.MILLISECONDS);
      mergedResult = merge(mergedResult, result);
    }

    executor.shutdown();
    executor.awaitTermination(5, TimeUnit.MINUTES);

    System.out.println(mergedResult);
  }

  public static Map<String, Integer> merge(Map<String, Integer> m1, Map<String, Integer> m2) {
    return m2.entrySet().stream()
        .collect(Collectors.toMap(
            Entry::getKey,
            Entry::getValue,
            Math::addExact,
            () -> new HashMap<>(m1)
        ));
  }

  public static Callable<Map<String, Integer>> countWords(Path path) {
    return () -> {
      Map<String, Integer> countByWord = new HashMap<>();

      String content = new String(Files.readAllBytes(path));
      String[] words = content.split("\\PL+");
      for (String word : words) {
        countByWord.merge(word, 1, Math::addExact);
      }

      return countByWord;
    };
  }

  public static Set<Path> descendants(Path path) throws IOException {
    return Files.walk(path)
        .filter(Files::isRegularFile)
        .collect(Collectors.toSet());
  }
}
