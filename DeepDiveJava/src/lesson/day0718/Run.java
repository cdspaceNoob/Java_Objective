package lesson.day0718;

public class Run {

	public static void main(String[] args) {
	
		Driver driver = new Driver();
		Vehicle vehicle = new Vehicle();
		Bus bus = new Bus();
		driver.drive(vehicle);
		driver.drive(bus);
	}
}
