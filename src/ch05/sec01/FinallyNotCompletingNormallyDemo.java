package ch05.sec01;

public class FinallyNotCompletingNormallyDemo {
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		} catch(NumberFormatException ex) {
			return 0;
		} finally {
			return -1;
		}
	}
	
	public static double parseDouble(String number) {
		try {
			return Double.parseDouble(number);
		} finally {
			throw new IllegalStateException();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(parseInt("Fred"));
		System.out.println(parseInt("123"));
		
		try {
			System.out.println(parseDouble("Fred"));
		} catch(Exception ex) {
			System.out.println("Caught " + ex.getClass().getName());
		}
		
		try {
			System.out.println(parseDouble("10.4"));
		} catch(Exception ex) {
			System.out.println("Caught " + ex.getClass().getName());
		}
	}
}
