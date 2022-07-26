package test;

public class InstanceAndStatic {
	/* field */
	public int a;
	public int static_a;
	
	public static void main(String[] args) {
		InstanceAndStatic ex = new InstanceAndStatic(); 
	}
	
	
	public static void setStatic_a(int number) {
	
	}
	
	public void setA(int number) {
		this.a = number;
	}

}
