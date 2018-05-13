package ch08.exercise.problem08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VowelTest {
	public static void main(String[] args) throws IOException {
		try (Stream<String> words = Files.lines(Paths.get("/usr/share/dict/words"))) {
			List<String> wordsContainingAllVowels = words
					.filter(w -> w.contains("u") 
							&& w.contains("o")
							&& w.contains("i")
							&& w.contains("a")
							&& w.contains("e"))
					.collect(Collectors.toList());
			System.out.println(wordsContainingAllVowels);
		}
	}
}
