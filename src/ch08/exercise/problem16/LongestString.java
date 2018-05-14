package ch08.exercise.problem16;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LongestString {
	public static void main(String[] args) throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("war_and_peace.txt")), StandardCharsets.UTF_8);
		List<String> words = new ArrayList<>(Arrays.asList(contents.split("\\PL+")));
		
		for (int i = 0; i < 10; ++i) {
			long startTime = System.currentTimeMillis();
			words.parallelStream().sorted(Comparator.comparing(String::length).reversed())
				.limit(500)
				.collect(Collectors.toList());
			System.out.println("parallel stream: " + (System.currentTimeMillis() - startTime));
			
			startTime = System.currentTimeMillis();
			words.stream().sorted(Comparator.comparing(String::length).reversed())
				.limit(500)
				.collect(Collectors.toList());
			System.out.println("stream: " + (System.currentTimeMillis() - startTime));
		}
	}
}
