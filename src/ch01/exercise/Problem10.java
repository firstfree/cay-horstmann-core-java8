package ch01.exercise;

import java.util.Random;

public class Problem10 {
	public static void main(String[] args) {
		System.out.println(to36(new Random().nextLong()));
	}
	
	public static String to36(long n) {
		System.out.println(n);
		return Long.toString(n, 36);
	}
}
