package ch03.sec01;

public class SquareSequence implements IntSequence {

	private int i;

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public int next() {
		i++;
		return i * i;
	}
}
