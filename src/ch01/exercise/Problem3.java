package ch01.exercise;

import java.util.Scanner;

public class Problem3 {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			
			System.out.println(a > b ? ((a > c) ? a : c) : ((b > c) ? b : c));
			System.out.println(Math.max(a, Math.max(b, c)));
		}
	}
}
