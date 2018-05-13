package ch08.exercise.problem03;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntArrayToIntStream {
	public static void main(String[] args) {
		int[] values = { 1, 4, 9, 16 };
		
		Stream<int[]> intArrayStream = Stream.of(values);
		intArrayStream.forEach(System.out::println);
		
		IntStream intStream = IntStream.of(values);
		intStream.forEach(System.out::println);
		
		intStream = Arrays.stream(values);
		intStream.forEach(System.out::println);
	}
}
