package ch05.exercise.problem10;

public class Factorial {
	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		
		new IllegalArgumentException().printStackTrace();
		
		return n * factorial(n - 1);
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(5));
	}
}
