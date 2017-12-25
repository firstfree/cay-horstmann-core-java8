package ch01.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Problem13 {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i < 50; i++) {
			numbers.add(i);
		}

		int[] selectedNumbers = new int[6];
		Random generator = new Random();
		for (int i = 0; i < 6; i++) {
			selectedNumbers[i] = numbers.remove(generator.nextInt(49 - i));
		}
		
		Arrays.sort(selectedNumbers);
		
		System.out.println(Arrays.toString(selectedNumbers));
	}
}
