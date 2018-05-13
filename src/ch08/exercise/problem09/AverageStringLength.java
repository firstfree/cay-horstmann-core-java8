package ch08.exercise.problem09;

import java.util.stream.Stream;

public class AverageStringLength {
	public static double averageStringLength(Stream<String> stream) {
		return stream.mapToInt(String::length).average().orElse(0L);
	}
	
	public static void main(String[] args) {
		double average = averageStringLength(Stream.of("word", "book", "int", "long", "double", "short", "float"));
		System.out.println(average);
	}
}
