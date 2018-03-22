package ch04.exercise.problem12;

import java.lang.reflect.Method;

public class MethodInvokationTimeTest {
	public static void main(String[] args) throws ReflectiveOperationException {
		Class<?> cl = Person.class;
		Object personObj = cl.newInstance();
		Method m = personObj.getClass().getMethod("setName", String.class);
		Person person = (Person) personObj;
		
		long startTime = System.nanoTime();
		person.setName("Mike");
		System.out.println(System.nanoTime() - startTime);
		
		startTime = System.nanoTime();
		m.invoke(personObj, "Mike");
		System.out.println(System.nanoTime() - startTime);
	}
	
	static class Person {
		private String name;

		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
	}
}
