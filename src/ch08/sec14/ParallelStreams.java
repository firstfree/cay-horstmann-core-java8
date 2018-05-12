package ch08.sec14;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParallelStreams {
	public static void main(String[] args) throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("\\PL+"));
		
		int[] shortWords = new int[10];
		words.parallelStream().forEach(w -> {
			if (w.length() < 10) {
				shortWords[w.length()]++;
			}
		});
		System.out.println(Arrays.toString(shortWords));
		
		Arrays.fill(shortWords, 0);
		words.parallelStream().forEach(w -> {
			if (w.length() < 10) {
				shortWords[w.length()]++;
			}
		});
		System.out.println(Arrays.toString(shortWords));
		
		Map<Integer, Long> shortWordCounts = words.parallelStream()
				.filter(w -> w.length() < 10)
				.collect(Collectors.groupingBy(String::length, Collectors.counting()));
		System.out.println(shortWordCounts);
		
		Map<Integer, List<String>> result = words.parallelStream().collect(
				Collectors.groupingByConcurrent(String::length));
		System.out.println(result.get(14));
		
		result = words.parallelStream().collect(
				Collectors.groupingByConcurrent(String::length));
		System.out.println(result.get(14));
		
		Map<Integer, Long> wordCounts = words.parallelStream().collect(
				Collectors.groupingByConcurrent(String::length,
						Collectors.counting()));
		System.out.println(wordCounts);
	}
}
