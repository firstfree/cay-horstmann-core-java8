package ch03.exercise.problem2;

import ch03.exercise.problem2.Employee;
import ch03.exercise.problem2.Measurable;

public class Problem2 {

	public static void main(String[] args) {
		Employee[] employees = new Employee[] { 
				new Employee("Mike", 10), 
				new Employee("Patrick", 20),
				new Employee("Satoshi", 33) };
		
		System.out.println(((Employee) Measurable.largest(employees)).getName());
	}
}
