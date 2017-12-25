package ch02.sec04;

public class Employee {

	private static int lastId;
	private int id;
	private String name;
	private double salary;

	public Employee() {
		lastId++;
		id = lastId;
	}

	public Employee(String name, double salary) {
		this();
		this.name = name;
		this.salary = salary;
	}

	/**
	 * 직원의 급여를 인상한다.
	 * @since version 1.7.1
	 * @param byPercent 급여 인상 백분율(예를 들어 10은 10%를 의미함)
	 * @return 인상 금액
	 */
	public double raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
		return raise;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
}
