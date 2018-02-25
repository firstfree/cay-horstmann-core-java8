package ch03.exercise.problem2;

public class Employee implements Measurable {

	private String name;
	private double salary;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public double getMeasure() {
		return salary;
	}
}
