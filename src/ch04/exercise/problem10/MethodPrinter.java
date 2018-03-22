package ch04.exercise.problem10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class MethodPrinter {
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.print("Class name: ");

		try (Scanner in = new Scanner(System.in)) {
			String className = in.nextLine();
			
			Class<?> cl = Class.forName(className);
			while (cl != null) {
				for (Method m : cl.getDeclaredMethods()) {
					System.out.println(
							Modifier.toString(m.getModifiers()) + " "
									+ m.getReturnType().getCanonicalName() + " "
									+ m.getName() + " "
									+ Arrays.toString(m.getParameters())
							);
				}
				
				cl = cl.getSuperclass();
			}
		}
	}
}
