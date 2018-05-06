package ch07.exercise.problem15;

import java.util.AbstractList;
import java.util.List;
import java.util.function.IntFunction;

public class InfiniteList {
	public static void main(String[] args) {
		List<Integer> infiniteList = infiniteList(n -> n * 2);
		System.out.println(infiniteList.get(9));
		System.out.println(infiniteList.get(999));
		System.out.println(infiniteList.get(99999));
		System.out.println(infiniteList.get(9999999));
	}
	
	public static List<Integer> infiniteList(IntFunction<Integer> func) {
		return new AbstractList<Integer>() {
			@Override
			public Integer get(int index) {
				return func.apply(index);
			}

			@Override
			public int size() {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean isEmpty() {
				return false;
			}

			@Override
			public Object[] toArray() {
				throw new UnsupportedOperationException();
			}

			@Override
			public <T> T[] toArray(T[] a) {
				throw new UnsupportedOperationException();
			}
		};
	}
}
