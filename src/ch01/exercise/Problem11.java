package ch01.exercise;

import java.util.Scanner;

public class Problem11 {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			String s = in.nextLine();

			for (int i = 0; i < s.length(); i++) {
				int codePoint = s.codePointAt(i);
				if (codePoint > 127) {
					System.out.printf("%c : %H\n", s.charAt(i), codePoint);
				}
			}
		}
	}
}