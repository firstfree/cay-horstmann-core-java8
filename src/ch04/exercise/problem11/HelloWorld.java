package ch04.exercise.problem11;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class HelloWorld {
	public static void main(String[] args) throws ReflectiveOperationException {
		Class<?> cl = Class.forName("java.lang.System");
		Field f = cl.getDeclaredField("out");
		Object out = f.get(null);
		Method println = out.getClass().getMethod("println", String.class);
		println.invoke(out, "Hello World!");
	}
}
