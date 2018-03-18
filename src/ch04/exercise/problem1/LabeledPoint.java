package ch04.exercise.problem1;

public class LabeledPoint extends Point {
	private String label;
	
	public LabeledPoint(String label, double x, double y) {
		super(x, y);
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
