package tostring;

public class ExampleClass {
	public String firstName;
	public String lastName;
	public int age;
	
	public ExampleClass(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "first name is: "+this.firstName+
				"\n"+"last name is: "+this.lastName+
				"\n"+"age is: "+this.age;
	}
}
