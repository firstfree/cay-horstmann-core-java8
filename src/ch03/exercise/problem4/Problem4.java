package ch03.exercise.problem4;

public class Problem4 {

	public static void main(String[] args) {
		IntSequence intSequence = IntSequence.of(3, 1, 4, 1, 5, 9);
		while (intSequence.hasNext()) {
			System.out.println(intSequence.next());
		}
	}
}
