package ch04.sec04;

public class ClassDemo {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Object obj = System.out;
		Class<?> cl = obj.getClass();
		
		System.out.println("This object is an instance of " + cl.getName());
		
		cl = Class.forName("java.util.Scanner");
		System.out.println(cl.getName());
		
		cl = java.util.Scanner.class;
		System.out.println(cl.getName());
		
		Class<?> cl2 = String[].class;
		System.out.println(cl2.getName());
		System.out.println(cl2.getCanonicalName());
		
		Class<?> cl3 = Runnable.class;
		System.out.println(cl3.getName());
		
		Class<?> cl4 = int.class;
		System.out.println(cl4.getName());
		
		Class<?> cl5 = void.class;
		System.out.println(cl5.getName());
	}
}
