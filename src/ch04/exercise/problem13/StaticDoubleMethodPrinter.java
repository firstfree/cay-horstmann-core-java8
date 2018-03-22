package ch04.exercise.problem13;

import java.lang.reflect.Method;
import java.util.function.DoubleFunction;

public class StaticDoubleMethodPrinter {
	
	public static void main(String[] args) throws ReflectiveOperationException {
		printStaticDoubleMethodResult(Math.class.getMethod("sqrt", double.class), 1, 10, 1);
		printStaticDoubleMethodResult(Double.class.getMethod("toHexString", double.class), 1, 10, 1);
		printStaticDoubleFunctionResult(Math::sqrt, 1, 10, 1);
		printStaticDoubleFunctionResult(Double::toHexString, 1, 10, 1);
	}

	public static void printStaticDoubleMethodResult(Method m, int min, int max, int increment) throws ReflectiveOperationException {
		for (int i = min; i <= max; i += increment) {
			System.out.printf("%d\t", i);
			System.out.println(m.invoke(m.getDeclaringClass(), i));
		}
	}
	
	public static void printStaticDoubleFunctionResult(DoubleFunction<Object> func, int min, int max, int increment) {
		for (int i = min; i <= max; i += increment) {
			System.out.printf("%d\t", i);
			System.out.println(func.apply(i));
		}
	}
}
