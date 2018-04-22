package ch06.exercise.problem20;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RepeatUtil {
	@SafeVarargs
	public static final <T> T[] repeat(int n, T... objs) {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) Array.newInstance(objs.getClass().getComponentType(), n * objs.length);
		
		for (int i = 0; i < n; ++i) {
			System.arraycopy(objs, 0, result, i * objs.length, objs.length);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(repeat(2, "a", "b", "c")));
	}
}
