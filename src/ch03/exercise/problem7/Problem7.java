package ch03.exercise.problem7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Problem7 {

	public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
		while(isNotSorted(strings, comp)) {
			Collections.shuffle(strings);
		}
	}
	
	private static boolean isNotSorted(ArrayList<String> strings, Comparator<String> comp) {
		for (int i = 0; i < strings.size() - 1; ++i) {
			if (comp.compare(strings.get(i), strings.get(i + 1)) > 0) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<>(Arrays.asList("b", "a", "e", "d"));
		
		luckySort(strings, String::compareTo);
		
		System.out.println(strings);
	}
}
