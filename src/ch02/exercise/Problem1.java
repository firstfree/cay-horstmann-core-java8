package ch02.exercise;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Problem1 {

	public static void main(String[] args) {

		LocalDate date = LocalDate.now().withDayOfMonth(1);

		int month;
		if (args.length > 1) {
			month = Integer.valueOf(args[0]);
			int year = Integer.valueOf(args[1]);
			date = LocalDate.of(year, month, 1);
		} else {
			month = date.getMonthValue();
		}

		System.out.println(" Sun Mon Tue Wed Thr Fri Sat");

		DayOfWeek weekday = date.getDayOfWeek();
		int value = weekday.getValue() % 7;
		for (int i = 0; i < value; i++) {
			System.out.print("    ");
		}

		int length = date.lengthOfMonth();
		for (int i = 0; i < length; i++) {
			System.out.printf("%4d", date.getDayOfMonth());
			date = date.plusDays(1);
			if ((date.getDayOfWeek() == DayOfWeek.SUNDAY) || (i == length - 1)) {
				System.out.println();
			}
		}
	}
}
