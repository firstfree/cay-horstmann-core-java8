package ch07.exercise.problem05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class SwapTest {
	public static void main(String[] args) {
		List<String> arrayStrings = new ArrayList<>(Arrays.asList("a", "b", "c"));
		swap(arrayStrings, 0, 2);
		System.out.println(arrayStrings);
		
		List<String> linkedStrings = new LinkedList<>(Arrays.asList("a", "b", "c"));
		swap(linkedStrings, 2, 0);
		System.out.println(linkedStrings);
	}
	
	public static void swap(List<?> list, int i, int j) {
		swapHelper(list, i, j);
	}
	
	private static <T> void swapHelper(List<T> list, int i, int j) {
		if (list instanceof RandomAccess) {
			list.set(i, list.set(j, list.get(i)));
		} else {
			ListIterator<T> firstIt = list.listIterator(i);
			T first = firstIt.next();
			
			ListIterator<T> secondIt = list.listIterator(j);
			T second = secondIt.next();
			
			secondIt.set(first);
			firstIt.set(second);
		}
	}
}
