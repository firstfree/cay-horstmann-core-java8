package ch06.exercise.problem06;

import java.util.ArrayList;

import ch06.sec06.Arrays;

public class ArrayLists {
	public static <E> ArrayList<E> addAllByPE(ArrayList<? extends E> org, ArrayList<E> dest) {
		dest.addAll(org);
		return dest;
	}
	
	public static <E> ArrayList<? super E> addAllByCS(ArrayList<E> org, ArrayList<? super E> dest) {
		dest.addAll(org);
		return dest;
	}
	
	public static void main(String[] args) {
		ArrayList<String> org = new ArrayList<>(Arrays.asList("a", "b"));
		ArrayList<String> dest = new ArrayList<>(Arrays.asList("c", "d"));
		System.out.println(addAllByPE(org, dest));
		System.out.println(addAllByCS(org, dest));
	}
}
