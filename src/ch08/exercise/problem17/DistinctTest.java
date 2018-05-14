package ch08.exercise.problem17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctTest {
	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<>();
		for (int i = 0; i < 10000; ++i) {
			integers.add(i);
			integers.add(i);
		}
		
		List<Integer> distinctIntegers = integers.parallelStream().distinct().collect(Collectors.toList());
		System.out.println(integers.size());
		System.out.println(distinctIntegers.size());
	}
}
