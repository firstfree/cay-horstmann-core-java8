package ch04.exercise.problem8;

import java.util.ArrayList;

public class ClassTest {

	public static void main(String[] args) {
		getTypeString(int[].class);
		getTypeString(ArrayList.class);
		getTypeString(InnerClass.class);
		getTypeString(int.class);
	}
	
	public static class InnerClass {
	}
	
	public static void getTypeString(Class<?> cl) {
		System.out.println(cl.getName());
		System.out.println(cl.getSimpleName());
		System.out.println(cl.getCanonicalName());
		System.out.println(cl.getTypeName());
		System.out.println(cl.toGenericString());
		System.out.println(cl.toString());
		System.out.println();
	}
}
