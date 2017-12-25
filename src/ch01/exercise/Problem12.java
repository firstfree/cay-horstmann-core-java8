package ch01.exercise;

public class Problem12 {
	public static void main(String[] args) {
		boolean b = false;

		for (int i = 0; i < 10; i++) {
			if (i > 5) {
				b = true;
				break;
			}
		}

		if (!b) {
			System.out.println("break label");
		}

		System.out.println("break end");

		int i = 0;

		while (i < 10) {
			int j = 0;

			while (j < 10) {
				j++;

				if (j > 5) {
					break;	// continue label;
				}

			}

			i++;

		}
		System.out.println("continue end");
	}
}