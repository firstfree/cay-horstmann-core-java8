package ch03.exercise.problem4;

public interface IntSequence {

	boolean hasNext();
	int next();
	
	static IntSequence of(int ...numbers) {
		return new IntSequence() {
			int position;
			
			@Override
			public int next() {
				return numbers[position++];
			}
			
			@Override
			public boolean hasNext() {
				return position < numbers.length;
			}
		};
	}
}
