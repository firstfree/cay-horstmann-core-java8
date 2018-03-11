package ch04.sec02;

public class Manager extends Employee {
	private double bonus;
	
	public Manager(String name, double salary) {
		super(name, salary);
	}
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public double getSalary() {
		return super.getSalary() + bonus;
	}
	
	@Override
	public String toString() {
		return super.toString() + "[bonus=" + bonus + "]"; 
	}
	
	@Override
	public Manager clone() throws CloneNotSupportedException {
		return (Manager) super.clone();
	}
}
