package lesson.day0715;

public class Final {
	
	private static final String species = "humnan";
	final int number;
	final String Nation="korea";
	public Final() {
		this.number = 5;
	}
	
	public String getSpecies() {
		return this.species;
	}
	public static void main(String[] args) {
		Final f = new Final();
		String g = f.getSpecies();
		System.out.println(g);
	}

}
