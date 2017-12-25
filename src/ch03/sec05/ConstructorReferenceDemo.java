package ch03.sec05;

import java.util.ArrayList;
import java.util.List;

public class ConstructorReferenceDemo {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Peter");
		names.add("Paul");
		names.add("Mary");
		Employee[] employees = names.stream().map(Employee::new).toArray(Employee[]::new);
		for (Employee e : employees) {
			System.out.println(e.getName());
		}
	}
}
