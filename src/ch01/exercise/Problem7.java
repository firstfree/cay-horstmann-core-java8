package ch01.exercise;

import java.util.Scanner;

public class Problem7 {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			short a = in.nextShort();
			short b = in.nextShort();

			System.out.printf("a + b = %d\n", Short.toUnsignedInt((short) (a + b)));
			System.out.printf("a - b = %d\n", Short.toUnsignedInt((short) (a - b)));
			System.out.printf("a * b = %d\n", Short.toUnsignedInt((short) (a * b)));
			System.out.printf("a / b = %d\n", Short.toUnsignedInt((short) (a / b)));
			System.out.printf("a %% b = %d\n", Short.toUnsignedInt((short) (a % b)));
		}
	}
}
