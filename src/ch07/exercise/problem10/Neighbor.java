package ch07.exercise.problem10;

public class Neighbor {
	private String name;
	private int distance;
	
	public Neighbor(String name, int distance) {
		this.name = name;
		this.distance = distance;
	}
	
	public String getName() {
		return name;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	@Override
	public String toString() {
		return "[name=" + name + ", distance=" + distance + "]";
	}
}
