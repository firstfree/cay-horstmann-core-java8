package ch07.exercise.problem16;

import java.util.AbstractList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.IntFunction;

public class ImprovedInfiniteList {
	public static void main(String[] args) {
		List<Integer> improvedInfiniteList = improvedInfiniteList(n -> n * 3);
		System.out.println(improvedInfiniteList.get(10));
		System.out.println(improvedInfiniteList.get(20));
		System.out.println(improvedInfiniteList.get(30));
	}
	
	public static List<Integer> improvedInfiniteList(IntFunction<Integer> func) {
		return new AbstractList<Integer>() {
			Map<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>(100) {
				private static final long serialVersionUID = 958755778806432122L;

				@Override
				protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
					return size() > 100;
				}
			};
			
			@Override
			public Integer get(int index) {
				return cache.computeIfAbsent(index, k -> func.apply(k));
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
