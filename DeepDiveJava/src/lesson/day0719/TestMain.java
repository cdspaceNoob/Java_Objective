package lesson.day0719;

public class TestMain {
	public static void main(String[] args) {
		/* Primitive - Wrapper - String CONVERSION PRACTICE */
		MyString ms = new MyString();
		
		ms.getStrVal();
		ms.getIntVal();
		
		ms.setIntVal(30);
		ms.setStrVal("changed");
		
		String str = ms.getStrVal();
		int integer = ms.getIntVal();
		
		String intToStr = String.valueOf(integer);
		int unInt = ms.intVal.intValue();
		System.out.println("is this STRING?: "+intToStr.getClass());
		System.out.println(unInt);
	}

}
