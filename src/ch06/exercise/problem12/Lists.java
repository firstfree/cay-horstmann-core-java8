package ch06.exercise.problem12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import ch06.sec06.Arrays;

public class Lists {
	public static <T> void minmax(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
		Iterator<T> iterator = elements.iterator();
		T min = iterator.next();
		T max = min;
		
		while (iterator.hasNext()) {
			T element = iterator.next();
			if (comp.compare(min, element) > 0)
				min = element;
			else if (comp.compare(max, element) < 0)
				max = element;
		}
		
		result.add(min);
		result.add(max);
	}
	
	public static void main(String[] args) {
		ArrayList<Object> result = new ArrayList<>();
		minmax(new ArrayList<>(Arrays.asList(12, 1, 3, 99, 4, 21)), Integer::compare, result);
		System.out.println(result);
	}
}
