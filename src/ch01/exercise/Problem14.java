package ch01.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Problem14 {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int[][] ms = null;
			int idx = 0;
			int n = 0;
			while (in.hasNextLine()) {
				String s = in.nextLine();

				if (s.length() < 1) {
					break;
				}

				int[] nums = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();

				if (ms == null) {
					n = nums.length;
					ms = new int[n][n];
				}

				ms[idx++] = nums;
			}

			System.out.println(checkMagicSquare(ms));
		}
	}

	public static boolean checkMagicSquare(int[][] ms) {
		int m = 0;
		int n = ms.length;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum += ms[i][j];
			}

			if (m < 1) {
				m = sum;
			}

			if (sum != m) {
				return false;
			}

			sum = 0;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum += ms[j][i];
			}

			if (sum != m) {
				return false;
			}

			sum = 0;
		}

		for (int i = 0; i < n; i++) {
			sum += ms[i][i];
		}

		if (sum != m) {
			return false;
		}

		sum = 0;
		for (int i = 0; i < n; i++) {
			sum += ms[i][n - i - 1];
		}

		if (sum != m) {
			return false;
		}

		return true;
	}
}
