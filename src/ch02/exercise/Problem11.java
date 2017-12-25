package ch02.exercise;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.LocalDate.*;
import static java.lang.System.out;

public class Problem11 {

	public static void main(String[] args) {

		LocalDate date = now().withDayOfMonth(1);

		int month;
		if (args.length >= 2) {
			month = Integer.parseInt(args[0]);
			int year = Integer.parseInt(args[1]);
			date = of(year, month, 1);
		} else {
			month = date.getMonthValue();
		}

		out.println("  Mon Tue Wed Thu Fri Sat Sun");
		DayOfWeek day = date.getDayOfWeek();
		int value = day.getValue();
		for (int i = 1; i < value; ++i) {
			out.print("    ");
		}

		while (month == date.getMonthValue()) {
			out.printf("%4d", date.getDayOfMonth());

			date = date.plusDays(1);

			if (date.getDayOfWeek().getValue() == 1) {
				out.println();
			}
		}

		if (date.getDayOfWeek().getValue() != 1) {
			out.println();
		}
	}
}
