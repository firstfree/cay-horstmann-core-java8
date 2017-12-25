package ch03.sec02;

public class Employee implements Person, Identified {

	private String name;

	public Employee(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getId() {
		return Identified.super.getId();
	}
}
