package ch01.sec04;

public class RelationalDemo {
	public static void main(String[] args) {
		int length = 10;
		int n = 7;
		System.out.println(0 <= n && n < length);

		int s = 30;
		System.out.println(n != 0 && s + (100 - s) / n < 50);

		n = 0;
		System.out.println(n != 0 && s + (100 - s) / n < 50);
		System.out.println(n == 0 || s + (100 - s) / n >= 50);

		int time = 7;
		System.out.println(time < 12 ? "am" : "pm");
		
		System.out.println(Integer.toBinaryString(0b0000000000001000 ^ 0xF));
		System.out.println(Integer.toBinaryString(~0xF));
		System.out.println(Integer.toBinaryString(~0xF));
		System.out.println(Integer.toBinaryString(0xF << 2));
		System.out.println(Integer.toBinaryString(0xF >> 2));
		System.out.println(Integer.toBinaryString(0xFFFFFFFF >> 2));
		System.out.println(Integer.toBinaryString(0xFFFFFFFF >>> 2));
		System.out.println(Integer.toBinaryString(-212512512));
		System.out.println(Integer.toBinaryString(-212512512 >>> 2));
		System.out.println(Integer.toBinaryString(1 << 35));
	}
}
