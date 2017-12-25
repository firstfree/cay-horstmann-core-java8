package ch01.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Problem8 {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			String s = in.nextLine();
			System.out.println(Arrays.toString(s.split(" ")));
		}
	}
}
