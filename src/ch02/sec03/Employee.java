package ch02.sec03;

import java.util.Random;

public class Employee {

	private String name = "";
	private final int id;
	private double salary;

	{
		Random generator = new Random();
		id = 1 + generator.nextInt(1_000_000);
	}
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public Employee(double salary) {
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
	
	public int getId() {
		return id;
	}
}
