package ch03.exercise.problem1;

public class Employee implements Measurable {

	private double salary;
	
	public Employee(double salary) {
		this.salary = salary;
	}
	
	@Override
	public double getMeasure() {
		return salary;
	}
}
