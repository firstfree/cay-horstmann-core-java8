package ch07.exercise.problem14;

import java.util.AbstractList;
import java.util.List;

public class ImmutableList {
	public static void main(String[] args) {
		List<Integer> immutableList = immutableList(10);
		immutableList.forEach(System.out::println);
	}
	
	public static List<Integer> immutableList(int n) {
		return new AbstractList<Integer>() {
			@Override
			public Integer get(int index) {
				if (index > n) {
					throw new IndexOutOfBoundsException();
				}
				
				return index;
			}

			@Override
			public int size() {
				return n + 1;
			}
			
			@Override
			public boolean isEmpty() {
				return false;
			}

			@Override
			public Integer[] toArray() {
				Integer[] array = new Integer[n + 1];
				for (int i = 0; i < n + 1; ++i) {
					array[i] = i;
				}
				
				return array;
			}

			@Override
			public <T> T[] toArray(T[] a) {
				throw new UnsupportedOperationException();
			}
		};
	}
}
