package equals;

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
			if(((Toy) obj).name != null && ((Toy) obj).name == this.name) {
				flag = true;
			}
		}
		return flag;
	}/* end equals */
}
