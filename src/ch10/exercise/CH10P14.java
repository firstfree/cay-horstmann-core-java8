package ch10.exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CH10P14 {

  public static final Map<String, Integer> m = new ConcurrentHashMap<>();

  public static void main(String[] args) throws IOException, InterruptedException {
    ExecutorService executor = Executors.newCachedThreadPool();

    Set<Path> paths = descendants(Paths.get("."));

    for (Path path : paths) {
      executor.execute(() -> {
        try {
          String content = new String(Files.readAllBytes(path));
          String[] words = content.split("\\PL+");
          for (String word : words) {
            m.merge(word, 1, Math::addExact);
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
    }

    executor.shutdown();
    executor.awaitTermination(5, TimeUnit.MINUTES);

    System.out.println(m);
  }

  public static Set<Path> descendants(Path path) throws IOException {
    return Files.walk(path)
        .filter(Files::isRegularFile)
        .collect(Collectors.toSet());
  }
}
