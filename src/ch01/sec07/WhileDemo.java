package ch01.sec07;

import java.util.Random;

public class WhileDemo {
	public static void main(String[] args) {
		Random generator = new Random();
		int sum = 0;
		int count = 0;
		int target = 90;
		while (sum < target) {
			sum += generator.nextInt(10);
			count++;
		}
		System.out.println("After " + count + " iterations, the sum is " + sum);
	}
}
