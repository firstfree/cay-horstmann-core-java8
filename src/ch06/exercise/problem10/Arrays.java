package ch06.exercise.problem10;

import java.util.Comparator;

public class Arrays {
	public static <T> T min(T[] array, Comparator<? super T> comp) {
		T min = array[0];
		for (int i = 1; i < array.length; ++i) {
			if (comp.compare(min, array[i]) > 0)
				min = array[i];
		}
		
		return min;
	}
	
	public static <T> T max(T[] array, Comparator<? super T> comp) {
		T max = array[0];
		for (int i = 1; i < array.length; ++i) {
			if (comp.compare(max, array[i]) < 0)
				max = array[i];
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		Integer[] array = {3, 1, 2, 4};
		System.out.println(min(array, Integer::compare));
		System.out.println(max(array, Integer::compare));
	}
}
