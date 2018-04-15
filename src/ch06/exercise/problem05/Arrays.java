package ch06.exercise.problem05;

public class Arrays {
	@SafeVarargs
	public static <T> T[] swap(int i, int j, T... values) {
		T temp = values[i];
		values[i] = values[j];
		values[j] = temp;
		return values;
	}
	
	public static void main(String[] args) {
		Double[] result = Arrays.swap(0, 1, 1.5d, 2d, 3d);
		System.out.println(java.util.Arrays.toString(result));
	}
}
