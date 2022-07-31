package equals;

import java.util.Objects;

public class Toy {
	private String name;
	private int price;
	private String manufacturing;
	
	public Toy(String name, int price, String manufacturing) {
		this.name = name;
		this.price = price;
		this.manufacturing = manufacturing;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean flag = false;
		if(obj instanceof Toy) {
			if(		((Toy) obj).name != null && ((Toy) obj).name == this.name &&
					((Toy) obj).price == this.price &&
					((Toy) obj).manufacturing != null && ((Toy) obj).manufacturing == this.manufacturing){
				return true;
			}
		}
		return false;
	}/* end equals */
	
	@Override
	public int hashCode() {
		return Objects.hash(name, price, manufacturing);
	}
}
