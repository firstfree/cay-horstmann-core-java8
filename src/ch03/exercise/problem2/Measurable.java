package ch03.exercise.problem2;

public interface Measurable {
	
	double getMeasure();
	
	static double average(Measurable[] objects) {
		double sum = 0;
		for (Measurable object : objects) {
			sum += object.getMeasure();
		}
		
		return sum / objects.length;
	}
	
	static Measurable largest(Measurable[] objects) {
		Measurable largestMeasurable = objects[0];
		
		if (objects.length == 1) {
			return largestMeasurable;
		}
		
		for (int i = 1; i < objects.length; ++i) {
			if (largestMeasurable.getMeasure() < objects[i].getMeasure()) {
				largestMeasurable = objects[i];
			}
		}
		
		return largestMeasurable;
	}
}
