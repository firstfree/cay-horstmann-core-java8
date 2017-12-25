package ch01.exercise;

import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			
			int r = ((n % 360) + 360) % 360;
			System.out.println(r);
			
			int f = Math.floorMod(n, 360);
			System.out.println(f);
		}
	}
}
