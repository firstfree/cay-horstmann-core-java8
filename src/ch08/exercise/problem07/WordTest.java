package ch08.exercise.problem07;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordTest {
	public static boolean isWord(String target) {
		if (target == null || target.isEmpty()) {
			return false;
		}
		
		return target.codePoints().allMatch(Character::isAlphabetic);
	}
	
	public static void main(String[] args) throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
		
		Stream<String> words = Stream.of(contents.split(" ")).filter(WordTest::isWord).limit(100);
		System.out.println(words.collect(Collectors.toList()));
		
		words = Stream.of(contents.split(" ")).filter(WordTest::isWord);
		Map<String, Long> wordCounts = words
				.collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
		List<Entry<String, Long>> mostFrequentWords = wordCounts.entrySet().stream()
				.sorted(Entry.comparingByValue(Comparator.reverseOrder()))
				.limit(10)
				.collect(Collectors.toList());
		System.out.println(mostFrequentWords);
	}
}
