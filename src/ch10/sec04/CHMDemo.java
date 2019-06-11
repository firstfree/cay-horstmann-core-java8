package ch10.sec04;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CHMDemo {

  public static ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();

  public static void process(Path path) {
    try {
      String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
      String[] words = contents.split("\\PL+");
      for (String word : words) {
        map.merge(word, 1L, Long::sum);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Set<Path> descendants(Path p) throws IOException {
    try (Stream<Path> entries = Files.walk(p)) {
      return entries.filter(Files::isRegularFile).collect(Collectors.toSet());
    }
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    int processors = Runtime.getRuntime().availableProcessors();
    ExecutorService executor = Executors.newFixedThreadPool(processors);
    Path pathToRoot = Paths.get(".");

    Set<Path> paths = descendants(pathToRoot);
    for (Path p : paths) {
      executor.execute(() -> process(p));
    }

    executor.shutdown();
    executor.awaitTermination(10, TimeUnit.MINUTES);
    System.out.println(map);
  }
}
