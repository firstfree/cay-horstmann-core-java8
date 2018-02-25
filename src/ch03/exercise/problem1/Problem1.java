package ch03.exercise.problem1;

public class Problem1 {

	public static void main(String[] args) {
		Employee[] employees = new Employee[] { 
				new Employee(10), 
				new Employee(20),
				new Employee(33) };
		
		System.out.println(Measurable.average(employees));
	}
}
