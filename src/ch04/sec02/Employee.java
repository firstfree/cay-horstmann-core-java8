package ch04.sec02;

public class Employee {
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
	
	public static void main(String[] args) {
		Employee emp = new Employee("Mike", 100);
		System.out.println(emp);
	}
}
