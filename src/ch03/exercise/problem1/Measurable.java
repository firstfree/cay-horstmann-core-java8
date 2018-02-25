package ch03.exercise.problem1;

public interface Measurable {
	
	double getMeasure();
	
	static double average(Measurable[] objects) {
		double sum = 0;
		for (Measurable object : objects) {
			sum += object.getMeasure();
		}
		
		return sum / objects.length;
	}
}
