package ch01.exercise;

import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			System.out.println(Integer.toBinaryString(n));
			System.out.println(Integer.toOctalString(n));
			System.out.println(Integer.toHexString(n));
			System.out.println(Double.toHexString(1.0 / n));
		}
	}
}
