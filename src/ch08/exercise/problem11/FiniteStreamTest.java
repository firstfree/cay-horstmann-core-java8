package ch08.exercise.problem11;

import java.util.stream.Stream;

public class FiniteStreamTest {
	public static <T> boolean isFinite(Stream<T> stream) {
		return stream.spliterator().estimateSize() != Long.MAX_VALUE;
	}
	
	public static void main(String[] args) {
		System.out.println(isFinite(Stream.of("a", "b", "c")));
		System.out.println(isFinite(Stream.generate(() -> Math.random())));
	}
}
