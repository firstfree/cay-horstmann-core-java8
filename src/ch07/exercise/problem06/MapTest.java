package ch07.exercise.problem06;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class MapTest {
	public static void main(String[] args) {
		LinkedHashMap<String, LinkedHashSet<Integer>> contents = new LinkedHashMap<>();
		initContents(contents);
		System.out.println(contents);
	}
	
	public static void initContents(LinkedHashMap<String, LinkedHashSet<Integer>> contents) {
		LinkedHashSet<Integer> aSet = new LinkedHashSet<>();
		aSet.add(1);
		aSet.add(3);
		aSet.add(2);
		
		LinkedHashSet<Integer> bSet = new LinkedHashSet<>();
		bSet.add(7);
		bSet.add(4);
		bSet.add(3);
		
		contents.put("a", aSet);
		contents.put("b", bSet);
	}
}
