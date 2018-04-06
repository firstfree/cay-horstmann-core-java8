package ch05.exercise.problem12;

import java.util.Arrays;

public class MinSelector {
	public int min(int[] values) {
		int min = Integer.MAX_VALUE;
		for (int value : values) {
			if (min > value) {
				min = value;
			}
		}
		
		int finalMin = min;
		assert Arrays.stream(values)
				.allMatch(v -> finalMin <= v) : finalMin + " is not the minimum value";
		
		return finalMin;
	}
}
