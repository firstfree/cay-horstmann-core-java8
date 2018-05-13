package ch08.exercise.problem05;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Letters {
	public static Stream<String> letters(String s) {
		return IntStream.range(0, s.length()).mapToObj(i -> s.substring(i, i + 1));
	}
	
	public static void main(String[] args) {
		Stream<String> letters = letters("letters");
		System.out.println(letters.collect(Collectors.toList()));
	}
}
