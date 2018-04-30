package ch07.exercise.problem02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ToUpperCase {
	public static void main(String[] args) {
		List<String> aStrings = new ArrayList<>(Arrays.asList("a", "bc", "def"));
		toUpperCaseA(aStrings);
		System.out.println(aStrings);
		
		List<String> bStrings = new ArrayList<>(Arrays.asList("a", "bc", "def"));
		toUpperCaseB(bStrings);
		System.out.println(bStrings);
		
		List<String> cStrings = new ArrayList<>(Arrays.asList("a", "bc", "def"));
		toUpperCaseC(cStrings);
		System.out.println(cStrings);
	}
	
	public static void toUpperCaseA(List<String> strings) {
		ListIterator<String> it = strings.listIterator();;
		while (it.hasNext()) {
			it.set(it.next().toUpperCase());
		}
	}
	
	public static void toUpperCaseB(List<String> strings) {
		for (int i = 0; i < strings.size(); ++i) {
			strings.set(i, strings.get(i).toUpperCase());
		}
	}
	
	public static void toUpperCaseC(List<String> strings) {
		strings.replaceAll(String::toUpperCase);
	}
}
