package ch01.exercise;

public class Problem16 {
	public static void main(String[] args) {
		System.out.println(average(12, 9, 195));
	}

	public static double average(double fn, double... nums) {
		double sum = fn;
		for (double n : nums) {
			sum += n;
		}

		return sum / (nums.length + 1);
	}
}
