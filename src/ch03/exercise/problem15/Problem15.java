package ch03.exercise.problem15;

import java.util.Random;

public class Problem15 {

	private static Random generator = new Random();
	
	private static class RandomSequence implements IntSequence {
		private int low;
		private int high;
		
		private RandomSequence(int low, int high) {
			this.low = low;
			this.high = high;
		}
		
		@Override
		public boolean hasNext() {
			return true;
		}

		@Override
		public int next() {
			return low + generator.nextInt(high - low + 1);
		}
	}
	
	public static IntSequence randomInts(int low, int high) {
		return new RandomSequence(low, high);
	}
	
	public static void main(String[] args) {
		IntSequence intSequence = randomInts(2, 5);
		System.out.println(intSequence.next());
		System.out.println(intSequence.next());
		System.out.println(intSequence.next());
		System.out.println(intSequence.next());
		System.out.println(intSequence.next());
	}
}
