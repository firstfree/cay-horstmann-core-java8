package ch03.sec02;

public class DigitSequence implements IntSequence {

	private int number;

	public DigitSequence(int number) {
		this.number = number;
	}

	public int rest() {
		return number;
	}

	@Override
	public int next() {
		int result = number % 10;
		number /= 10;
		return result;
	}
}
