package ch01.exercise;

import java.math.BigInteger;

public class Problem6 {
	public static void main(String[] args) {
		System.out.println(factorial(1000));
	}
	
	public static BigInteger factorial(int n) {
		if (n < 2) {
			return BigInteger.ONE;
		}
		
		return BigInteger.valueOf(n).multiply(factorial(n - 1));
	}
}
