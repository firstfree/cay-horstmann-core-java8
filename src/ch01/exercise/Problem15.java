package ch01.exercise;

import java.util.ArrayList;
import java.util.List;

public class Problem15 {
	public static void main(String[] args) {
		List<List<Integer>> pt = getPascalTriangle(20);
		System.out.println(pt.toString());
	}

	public static List<List<Integer>> getPascalTriangle(int n) {
		List<List<Integer>> pt = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			List<Integer> nr = new ArrayList<>();
			nr.add(1);

			if (i > 1) {
				List<Integer> pr = pt.get(i - 1);
				for (int j = 1; j < i; j++) {
					nr.add(pr.get(j - 1) + pr.get(j));
				}
			}

			if (i > 0) {
				nr.add(i, 1);
			}

			pt.add(nr);
		}

		return pt;
	}
}
