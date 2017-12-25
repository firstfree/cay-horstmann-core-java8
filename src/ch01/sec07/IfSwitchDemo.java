package ch01.sec07;

public class IfSwitchDemo {
	public static void main(String[] args) {
		int count = 5;
		if (count > 0) {
			double average = 10 / count;
			System.out.println(average);
		} else if (count == 0) {
			System.out.println(0);
		} else {
			System.out.println("Huh?");
		}

		String output = null;
		System.out.println(output);
		switch (count) {
		case 0:
			output = "None";
			break;
		case 1:
			output = "One";
			break;
		case 2:
		case 3:
		case 4:
		case 5:
			output = Integer.toString(count);
			break;
		default:
			output = "Many";
			break;
		}
		System.out.println(output);
	}
}
