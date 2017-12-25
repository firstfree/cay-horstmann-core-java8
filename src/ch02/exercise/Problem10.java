package ch02.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Problem10 {

	public static void main(String[] args) {
		System.out.println(RandomNumbers.randomElement(Arrays.asList(1, 2, 3, 4)));
		System.out.println(RandomNumbers.randomElement(new int[] { 1, 2, 3, 4 }));
	}

	public static class RandomNumbers {

		private static final Random generator = new Random();

		public static int nextInt(int low, int high) {
			return low + generator.nextInt(high - low + 1);
		}

		public static int randomElement(int[] arr) {
			if (arr == null || arr.length == 0) {
				return 0;
			}

			return arr[generator.nextInt(arr.length)];
		}

		public static int randomElement(List<Integer> list) {
			if (list == null || list.size() == 0) {
				return 0;
			}

			return list.get(generator.nextInt(list.size()));
		}
	}
}
