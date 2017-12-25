package ch02.exercise;

public class Problem9 {

	public static void main(String[] args) {
		Car car = new Car(0.5f);
		System.out.println(car);

		car.fuelUp(10.0f);
		System.out.println(car);

		car.move(2.0f);
		System.out.println(car);
	}

	public static class Car {
		private float gallons;
		private float fuelEfficiency;
		private float distance;

		public Car(float fuelEfficiency) {
			this.fuelEfficiency = fuelEfficiency;
		}

		public void move(float miles) {
			gallons -= miles / fuelEfficiency;
			distance += miles;
		}

		public void fuelUp(float fuel) {
			gallons += fuel;
		}

		@Override
		public String toString() {
			return "Car [gallons=" + gallons + ", fuelEfficiency=" + fuelEfficiency + ", distance=" + distance + "]";
		}
	}
}
