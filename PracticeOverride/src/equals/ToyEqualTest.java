package equals;

public class ToyEqualTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Toy gun = new Toy("gun", 15000, "Lockheed Martin");
		Toy waterGun = new Toy("gun", 15000, "Lockheed Martin");
		
		System.out.println(gun.equals(waterGun));
	
	}

}
