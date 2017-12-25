package ch01.sec02;

public class NumberDemo {
	public static void main(String[] args) {
		System.out.println(4000000000L);
		System.out.println(0xCAFEBABE);
		System.out.println(0b1001);
		System.out.println(011);

		System.out.println(1_000_000_000);
		System.out.println(0b1111_0100_0010_0100_0000);

		System.out.println(Byte.toUnsignedInt((byte) -127));

		System.out.println(3.14F);
		System.out.println(3.14);
		System.out.println(3.14D);
		System.out.println(0x1.0p-3);

		System.out.println(1.0 / 0.0);
		System.out.println(-1.0 / 0.0);
		System.out.println(0.0 / 0.0);

		System.out.println(1.0 / 0.0 == Double.POSITIVE_INFINITY);
		System.out.println(-1.0 / 0.0 == Double.NEGATIVE_INFINITY);
		System.out.println(0.0 / 0.0 == Double.NaN);

		System.out.println(Double.isInfinite(1.0 / 0.0));
		System.out.println(Double.isNaN(0.0 / 0.0));
		System.out.println(Double.isFinite(0.0 / 0.0));

		System.out.println(2.0 - 1.1);
		
		System.out.println('J');
		System.out.println('J' == 74);
		System.out.println('\u004A');
		System.out.println('\u263A');
	}
}
