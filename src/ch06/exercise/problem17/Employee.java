package ch06.exercise.problem17;

public class Employee implements Comparable<Employee> {
	private int id;
	private String name;
	private int salary;
	
	public Employee(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public final int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSalary() {
		return salary;
	}

	@Override
	public int compareTo(Employee o) {
		return Integer.compare(id, o.id);
	}
	
	public static void main(String[] args) {
		Employee employee = new Employee(1, "Jack", 100);
		Comparable<Employee> comparable = employee;
		System.out.println(comparable.compareTo(new Employee(1, "Sarah", 100)));
	}
}
