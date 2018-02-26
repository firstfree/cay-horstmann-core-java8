package ch03.exercise.problem6;

import java.util.Iterator;

public class DigitSequence implements Iterator<Integer> {

	private int number;
	
	public DigitSequence(int number) {
		this.number = number;
	}
	
	public int rest() {
		return number;
	}
	
	@Override
	public boolean hasNext() {
		return number != 0;
	}

	@Override
	public Integer next() {
		int result = number % 10;
		number /= 10;
		return result;
	}

	@Override
	public void remove() {
	}
}
