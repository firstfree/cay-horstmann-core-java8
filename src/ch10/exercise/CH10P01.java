package ch10.exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CH10P01 {

  public static void main(String[] args) throws IOException {
    String word = "java";

    Path foundPath = Files.walk(Paths.get("."))
        .parallel()
        .filter(Files::isRegularFile)
        .filter(path -> path.getFileName().toString().contains(word))
        .findFirst()
        .get();

    System.out.println(foundPath.getFileName());
  }
}
