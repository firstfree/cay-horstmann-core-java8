package ch06.exercise.problem09;

import java.util.ArrayList;

public class Arrays {
	public static <E> Pair<E> firstLast(ArrayList<? extends E> a) {
		return new Pair<>(a.get(0), a.get(a.size() - 1));
	}
}
