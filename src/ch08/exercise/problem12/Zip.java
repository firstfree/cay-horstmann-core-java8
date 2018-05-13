package ch08.exercise.problem12;

import java.util.Arrays;
import java.util.stream.Stream;

public class Zip {
	@SuppressWarnings("unchecked")
	public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
		Object[] firstObjects = first.toArray();
		Object[] secondObjects = second.toArray();
		
		int maxLength = Math.max(firstObjects.length, secondObjects.length);
		Object[] newObjects = new Object[maxLength * 2];
		for (int i = 0; i < maxLength; ++i) {
			if (i < firstObjects.length)
				newObjects[i * 2] = firstObjects[i];
			if (i < secondObjects.length)
				newObjects[i * 2 + 1] = secondObjects[i];
		}
		
		return (Stream<T>) Arrays.stream(newObjects);
	}
	
	public static void main(String[] args) {
		Stream<String> first = Stream.of("a", "c", "e", "g", "i");
		Stream<String> second = Stream.of("b", "d", "f", "h");
		Stream<String> third = zip(first, second);
		third.forEach(System.out::println);
	}
}
