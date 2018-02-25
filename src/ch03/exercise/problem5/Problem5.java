package ch03.exercise.problem5;

public class Problem5 {

	public static void main(String[] args) {
		IntSequence intSequence = IntSequence.constant(1);
		while (intSequence.hasNext()) {
			System.out.println(intSequence.next());
		}
	}
}
