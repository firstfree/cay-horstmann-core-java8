package ch06.exercise.problem21;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysUtil {
	@SafeVarargs
	public static <T> T[] construct(int n, T... objs) {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) Array.newInstance(objs.getClass().getComponentType(), n);
		return result;
	}
	
	public static void main(String[] args) {
		List<String>[] strings = ArraysUtil.construct(10, Collections.emptyList());
		strings[0] = Arrays.asList("a", "b");
		System.out.println(Arrays.toString(strings));
	}
}
