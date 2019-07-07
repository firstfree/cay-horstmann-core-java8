package ch10.exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

public class CH10P18 {

  public static LongAdder counter = new LongAdder();

  public static void main(String[] args) throws IOException {
    Set<Path> paths = descendants(Paths.get("."));
    paths.parallelStream()
      .forEach(path -> {
        try {
          String content = new String(Files.readAllBytes(path));
          String[] words = content.split("\\PL+");
          counter.add(words.length);
        } catch (IOException e) {
          e.printStackTrace();
        }
      });

    System.out.println(counter);
  }

  public static Set<Path> descendants(Path path) throws IOException {
    return Files.walk(path)
        .filter(Files::isRegularFile)
        .collect(Collectors.toSet());
  }
}
