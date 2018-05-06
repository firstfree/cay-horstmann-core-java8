package ch07.exercise.problem14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ImmutableListView {
	public static void main(String[] args) {
		List<Integer> immutableList = immutableList(10);
		immutableList.forEach(System.out::println);
	}
	
	public static List<Integer> immutableList(int n) {
		return new ArrayList<Integer>() {
			private static final long serialVersionUID = 9113088213196544933L;

			@Override
			public int size() {
				return n + 1;
			}

			@Override
			public boolean isEmpty() {
				return false;
			}

			@Override
			public Integer get(int index) {
				if (index > n) {
					throw new IndexOutOfBoundsException();
				}
				
				return index;
			}

			@Override
			public Integer set(int index, Integer element) {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean add(Integer e) {
				throw new UnsupportedOperationException();
			}

			@Override
			public void add(int index, Integer element) {
				throw new UnsupportedOperationException();
			}

			@Override
			public Integer remove(int index) {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean remove(Object o) {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean removeIf(Predicate<? super Integer> filter) {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean addAll(Collection<? extends Integer> c) {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean addAll(int index, Collection<? extends Integer> c) {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				throw new UnsupportedOperationException();
			}
			
			@Override
			public void forEach(Consumer<? super Integer> action) {
				for (int i = 0; i <= n; ++i) {
					action.accept(i);
				}
			}
			
			@Override
			public void sort(Comparator<? super Integer> c) {
			}
		};
	}
}
