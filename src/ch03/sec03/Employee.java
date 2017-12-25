package ch03.sec03;

import java.util.Arrays;

public class Employee implements Comparable<Employee> {

	private String name;
	private double salary;

	public static void main(String[] args) {

		Employee[] empList = new Employee[] { new Employee(20), new Employee(10), new Employee(3) };

		System.out.println(Arrays.deepToString(empList));
		
		Arrays.sort(empList);
		
		System.out.println(Arrays.deepToString(empList));
	}

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public Employee(double salary) {
		this.name = "";
		this.salary = salary;
	}

	public Employee(String name) {
		this.name = name;
	}

	public Employee() {
		this("", 0);
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public int compareTo(Employee other) {
		return Double.compare(salary, other.salary);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
}
