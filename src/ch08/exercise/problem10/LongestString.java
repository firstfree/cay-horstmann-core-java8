package ch08.exercise.problem10;

import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestString {
	public static Optional<List<String>> findLongestString(Stream<String> stream) {
		return stream.collect(Collectors.groupingBy(String::length))
				.entrySet()
				.stream()
				.max(Entry.comparingByKey())
				.map(Entry::getValue);
	}
	
	public static void main(String[] args) {
		System.out.println(findLongestString(Stream.of("aaa", "bb", "ccc", "dddd", "ee", "ffff", "g")));
	}
}
