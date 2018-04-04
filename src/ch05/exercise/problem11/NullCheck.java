package ch05.exercise.problem11;

import java.util.Objects;

public class NullCheck {
	public static Object testRequireNonNull(Object obj) {
		return Objects.requireNonNull(obj);
	}
	
	private static Object testAssertNull(Object obj) {
		assert obj != null;
		return obj;
	}
	
	public static void main(String[] args) {
		Object obj = new Object();
		
		obj = testRequireNonNull(obj);
		
		if (obj == null) {
			throw new IllegalArgumentException();
		}
		
		testAssertNull(obj);
	}
}
