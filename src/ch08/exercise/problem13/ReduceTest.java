package ch08.exercise.problem13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ReduceTest {
	public static <T> List<T> mergeOne(Stream<List<T>> stream) {
		return stream.reduce((a, b) -> {
			List<T> newList = new ArrayList<>(a);
			newList.addAll(b);
			return newList;
		}).orElse(new ArrayList<>());
	}
	
	public static <T> List<T> mergeTwo(Stream<List<T>> stream) {
		return stream.reduce(new ArrayList<T>(), (a, b) -> {
			a.addAll(b);
			return a;
		});
	}
	
	public static <T> List<T> mergeThree(Stream<List<T>> stream) {
		return stream.reduce(new ArrayList<T>(),
				(a, b) -> {
					ArrayList<T> newList = new ArrayList<>(a);
					newList.addAll(b);
					return newList;
				},
				(total1, total2) -> {
					total1.addAll(total2);
					return total1;
				});
	}
	
	public static void main(String[] args) {
		List<String> a = new ArrayList<>(Arrays.asList("a", "b", "c"));
		List<String> b = new ArrayList<>(Arrays.asList("d", "e", "f"));
		List<String> c = new ArrayList<>(Arrays.asList("g", "h", "i"));
		List<String> d = new ArrayList<>(Arrays.asList("j", "k", "l"));
		List<String> e = new ArrayList<>(Arrays.asList("m", "n", "o"));
		List<String> f = new ArrayList<>(Arrays.asList("p", "q", "r"));
		List<String> g = new ArrayList<>(Arrays.asList("s", "t", "u"));
		List<String> h = new ArrayList<>(Arrays.asList("v", "w", "x"));
		
		List<String> result = mergeOne(Stream.of(a, b, c, d, e, f, g, h));
		System.out.println(result);
		
		result = mergeTwo(Stream.of(a, b, c, d, e, f, g, h));
		System.out.println(result);
		
		result = mergeThree(Stream.of(a, b, c, d, e, f, g, h).parallel());
		System.out.println(result);
	}
}
