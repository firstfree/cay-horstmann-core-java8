package ch01.sec06;

public class PrintDemo {
	public static void main(String[] args) {
		System.out.printf("%8.2f\n", 1000.0 / 3.0);
		
		int n = 10;
		double d = 3.141592;
		System.out.printf("%d\n", n);
		System.out.printf("%x %X\n", n, n);
		System.out.printf("%o\n", n);
		System.out.printf("%f\n", d);
		System.out.printf("%e %E\n", d, d);
		System.out.printf("%g %G\n", d, d);
		System.out.printf("%a %A\n", d, d);
		System.out.printf("%s %S\n", n, n);
		System.out.printf("%c %C\n", 'A', 'a');
		System.out.printf("%b %B\n", n, n);
		System.out.printf("%h %H\n", d, d);
		System.out.printf("%%\n", n);
		System.out.printf("%,+.2f\n", -d * 10000);
		System.out.printf("% f\n", d);
		System.out.printf("%20f\n", d);
		System.out.printf("%-20f\n", d);
		System.out.printf("%020f\n", d);
		System.out.printf("%(f\n", -d);
		System.out.printf("%x %#x\n", 12, 12);
		System.out.printf("%2$d %1$d\n", 12, 16);
		System.out.printf("%d %<d\n", 12, 16);
		
		String message = String.format("Hello, %s. Next year, you'll be %d.\n", "John", 12);
		System.out.printf(message);
	}
}
