package ch06.sec02;

public class ArraysDemo {
	public static void main(String[] args) {
		String[] friends = {"Peter", "Mary", "Paul"};
		Arrays.swap(friends, 0, 2);
		System.out.println(java.util.Arrays.toString(friends));
		
//		Double[] result = Arrays.swap(0, 1, 1.5, 2, 3.2);
//		System.out.println(java.util.Arrays.toString(result));
	}
}
