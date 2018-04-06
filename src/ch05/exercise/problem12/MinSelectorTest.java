package ch05.exercise.problem12;

import java.util.Random;

public class MinSelectorTest {
	public static void main(String[] args) {
		Random generator = new Random();
		
		int[] values = new int[10000000];
		for (int i = 0; i < values.length; ++i) {
			values[i] = i + generator.nextInt(10000);
		}
		
		ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
		
		long startTime = System.nanoTime();
		
		MinSelector minSelector = new MinSelector();
		System.out.println(minSelector.min(values));
		
		System.out.println(System.nanoTime() - startTime);
	}
}
