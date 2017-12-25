package ch01.sec07;

import java.util.Random;

public class ForDemo {
	public static void main(String[] args) {
		Random generator = new Random();
		int count = 20;
		int sum = 0;
		for (int i = 1; i <= count; i++) {
			sum += generator.nextInt(10);
		}
		
		System.out.println("After " + count + " iterations, the sum is " + sum);
	}
}
