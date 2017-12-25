package ch02.exercise;

import org.omg.CORBA.IntHolder;

public class Problem4 {

	public static void main(String[] args) {
		IntHolder a = new IntHolder(10);
		IntHolder b = new IntHolder(20);
		
		swap(a, b);
		
		System.out.println(a.value + " : " + b.value);
	}
	
	public static void swap(IntHolder a, IntHolder b) {
		int temp = a.value;
		a.value = b.value;
		b.value = temp;
	}
}
