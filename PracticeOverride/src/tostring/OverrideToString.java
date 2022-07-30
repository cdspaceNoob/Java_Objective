package tostring;

public class OverrideToString {
	public static void main(String[] args) {
		ExampleClass ex = new ExampleClass("Voyager", "Explorer", 33);
		
		System.out.println(ex.toString());
	}
}
