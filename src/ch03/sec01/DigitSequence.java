package ch03.sec01;

public class DigitSequence implements IntSequence {

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
	public int next() {
		int result = number % 10;
		number /= 10;
		return result;
	}
}
