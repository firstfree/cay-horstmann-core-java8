package ch04.sec01;

public class InheritanceDemo {
	public static void main(String[] args) {
		Manager boss = new Manager("Fred", 200000);
		
		boss.setBonus(10000);
		System.out.println(boss.getSalary());
		
		boss.raiseSalary(5);
		System.out.println(boss.getSalary());
		
		Employee empl = boss;
		
		empl.raiseSalary(5);
		System.out.println(empl.getSalary());
		
		if (empl instanceof Manager) {
			Manager mgr = (Manager) empl;
			mgr.setBonus(20000);
		}
	}
}
