package ch03.exercise.problem14;

public class Employee {

	public String name;
	public double salary;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	@Override
	public String toString() {
		return name + " " + String.valueOf(salary);
	}
}
