package ch06.exercise.problem15;

import java.util.ArrayList;
import java.util.function.Function;

import ch06.sec06.Arrays;


public class MapUtil {
	public static <T, R> ArrayList<R> map(ArrayList<T> elems, Function<T, R> func) {
		ArrayList<R> mappedElems = new ArrayList<>();
		for (T elem : elems) {
			mappedElems.add(func.apply(elem));
		}
		
		return mappedElems;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> elems = map(new ArrayList<>(Arrays.asList("1", "2", "3")), Integer::valueOf);
		System.out.println(elems);
	}
}
