package ch07.exercise.problem04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationTest {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		Iterator<Integer> it = numbers.iterator();
		while (it.hasNext()) {
//			numbers.remove(it.next());	throw ConcurrentModificationException
			
			it.next();
			it.remove();
		}
	}
}
