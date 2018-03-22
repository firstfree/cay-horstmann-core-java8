package ch05.sec01;

import java.util.Random;

public class ThrowDemo {
	private static Random generator = new Random();
	
	public static int randInt(int low, int high) {
		if (low > high) {
			throw new IllegalArgumentException(
					String.format("low should be <= high but low is %d and high is %d", low, high));
		}
		
		return low + generator.nextInt(high - low + 1);
	}
	
	public static void main(String[] args) {
		int r = randInt(5, 10);
		System.out.println(r);
		r = randInt(10, 5);
		System.out.println(r);
	}
}
