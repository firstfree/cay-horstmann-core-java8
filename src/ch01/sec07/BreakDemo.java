package ch01.sec07;

public class BreakDemo {
	public static void main(String[] args) {
		outer:
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (j == 10) {
					break outer;
				}
			}
			System.out.println(i);
		}
		
		outer: {
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					if (j == 10) {
						break outer;
					}
				}
				System.out.println(i);
			}
			for (int i = 0; i < 20; i++) {
				System.out.println(i);
			}
		}
	}
}
