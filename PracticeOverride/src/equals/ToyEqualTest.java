package equals;

public class ToyEqualTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Toy gun = new Toy("gun", 15000, "Lockheed Martin");
		Toy waterGun = new Toy("gun", 15000, "Lockheed Martin");
		Toy fireGun = new Toy("Fire Gun", 15000, "Ragnaros");
		
		System.out.println(gun.equals(waterGun));
		System.out.println(gun.equals(fireGun));
		System.out.println(waterGun.equals(fireGun));
	
	}

}
