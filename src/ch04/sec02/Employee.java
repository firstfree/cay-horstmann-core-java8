package ch04.sec02;

public class Employee implements Cloneable {
	private String name;
	private double salary;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public void raiseSalary(double byPercent) {
		salary += salary * byPercent / 100;
	}
	
	public final String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	@Override
	public String toString() {
		return getClass().getName() + "[name=" + name
				+ ",salary=" + salary + "]";
	}
	
	@Override
	public Employee clone() throws CloneNotSupportedException {
		return (Employee) super.clone();
	}
}
