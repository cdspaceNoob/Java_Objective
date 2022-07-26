package test;

public class AutoBoxing {
	
	private int intVal = 10;
	
	
	public static void main(String[] args) {
		AutoBoxing ab = new AutoBoxing();
		System.out.println(ab.getIntVal().getClass().getName());
	}
	
	
	public Integer getIntVal() {
		return this.intVal;
	}

}
