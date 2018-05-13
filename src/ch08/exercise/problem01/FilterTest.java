package ch08.exercise.problem01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterTest {
	public static void main(String[] args) throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("\\PL+"));
		List<String> firstWords = words.stream()
			.filter(w -> w.length() > 5)
			.peek(System.out::println)
			.limit(5)
			.collect(Collectors.toList());
		System.out.println(firstWords);
	}
}
