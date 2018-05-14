package ch08.exercise.problem12;

import java.util.Arrays;
import java.util.stream.Stream;

public class Zip {
	@SuppressWarnings("unchecked")
	public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
		Object[] firstObjects = first.toArray();
		Object[] secondObjects = second.toArray();
		Object[] newObjects = new Object[Math.max(firstObjects.length, secondObjects.length) * 2];
		
		int minLength = Math.min(firstObjects.length, secondObjects.length);
		for (int i = 0; i < minLength; ++i) {
			newObjects[i * 2] = firstObjects[i];
			newObjects[i * 2 + 1] = secondObjects[i];
		}
		
		for (int i = minLength; i < firstObjects.length; ++i) {
			newObjects[i * 2] = firstObjects[i];
		}
		
		for (int i = minLength; i < secondObjects.length; ++i) {
			newObjects[i * 2 + 1] = secondObjects[i];
		}
		
		return (Stream<T>) Arrays.stream(newObjects);
	}
	
	public static void main(String[] args) {
		Stream<String> first = Stream.of("a", "c", "e");
		Stream<String> second = Stream.of("b", "d", "f", "h", "j");
		Stream<String> third = zip(first, second);
		third.forEach(System.out::println);
	}
}
