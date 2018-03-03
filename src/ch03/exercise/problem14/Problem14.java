package ch03.exercise.problem14;

import java.util.Arrays;
import java.util.Comparator;

public class Problem14 {

	public static Employee[] sortAscBySalary(Employee... employees) {
		Comparator<Employee> comp = Comparator.comparing(Employee::getSalary)
				.thenComparing(Employee::getName);

		Arrays.sort(employees, comp);
		
		return employees;
	}
	
	public static Employee[] sortDescBySalary(Employee... employees) {
		Comparator<Employee> comp = Comparator.comparing(Employee::getSalary)
				.reversed()
				.thenComparing(Employee::getName);
		
		Arrays.sort(employees, comp);
		
		return employees;
	}

	public static void main(String[] args) {
		Employee[] employees = new Employee[] {
				new Employee("C", 1.0),
				new Employee("A", 1.2),
				new Employee("B", 0.3),
				new Employee("B", 1.0),
				new Employee("Z", 1.0)
		};
		
		employees = sortAscBySalary(employees);
		System.out.println(Arrays.toString(employees));
		
		employees = sortDescBySalary(employees);
		System.out.println(Arrays.toString(employees));
	}
}
