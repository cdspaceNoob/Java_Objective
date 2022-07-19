package lesson.day0719;

public class MyString {

	
	/* set up with Primitive */
//	Integer intVal = new Integer(10); 
//	constructor Integer: deprecated
	Integer intVal = Integer.valueOf(10);
	String strVal = String.valueOf(intVal);
	
	public String getStrVal() {
		System.out.println("strVal: "+this.strVal);
		System.out.println("class of strVal: "+this.strVal.getClass());
		return this.strVal;
	}
	
	public int getIntVal() {
		System.out.println("IntVal: "+this.intVal);
		System.out.println("class of intVal: "+this.intVal.getClass());
		return this.intVal;
	}
	
	public void setStrVal(String str) {
		this.strVal = str;
	}
	
	public void setIntVal(int integer) {
		this.intVal = integer;
	}
	
	
	
	
}
