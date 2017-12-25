package ch02.sec05;

import static java.lang.Math.*;

public class StaticImportDemo {

	public static void main(String[] args) {
		double x = 3;
		double y = 4;
		double hypotenuse = sqrt(pow(x, 2) + pow(y, 2));
		System.out.println(hypotenuse);
	}
}
