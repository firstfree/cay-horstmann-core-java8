package ch07.exercise.problem03;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		Set<Integer> setA = new HashSet<>();
		setA.add(1);
		setA.add(3);
		setA.add(5);
		setA.add(7);
		
		Set<Integer> setB = new HashSet<>();
		setB.add(2);
		setB.add(3);
		setB.add(6);
		setB.add(8);
		
//		setA.retainAll(setB);		intersect
//		setA.addAll(setB);			union
		setA.removeAll(setB);	//	difference
		System.out.println(setA);
	}
}
