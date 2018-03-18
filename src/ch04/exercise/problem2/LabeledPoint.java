package ch04.exercise.problem2;

import java.util.Objects;

public class LabeledPoint extends Point {
	private String label;
	
	public LabeledPoint(String label, double x, double y) {
		super(x, y);
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	@Override
	public String toString() {
		return super.toString() + "[label=" + label + "]";
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject)) {
			return false;
		}
		
		LabeledPoint other = (LabeledPoint) otherObject;
		
		return Objects.equals(other.getLabel(), label);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), label);
	}
}
