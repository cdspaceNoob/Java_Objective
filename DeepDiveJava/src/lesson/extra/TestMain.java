package lesson.extra;

import java.util.ArrayList;

// static에는 어떻게든 접근할 수 있지만 instance에는 객체를 생성하여 접근해야 한다 
public class TestMain {
	private int age;
	public static String firstname = "kim";
	
	public static void main(String[] args) {
		System.out.println(TestMain.firstname);
		TestMain tm = new TestMain();
		tm.firstname = "lee";
		tm.age = 10;
		test1();
		tm.test1();
	}
	
	public void test4() {
		Person kim = new Student();
	}
	
	
	public void test2() {
		System.out.println(this.age);	// this는 객체가 생성될 때 생성된다 
	}
	
	public static void test1() {
		TestMain tm2 = new TestMain();
		
		System.out.println(tm2.age);
		System.out.println(TestMain.firstname);
		System.out.println(tm2.firstname);
	}
	
	
	public void test3() {
		int a = 10;
		boolean result = a > 10 ? true : false;
		String resultStr = a > 10? "true":"false";
		
	}
	
	public void test5() {
		/* not generic */
		ArrayList list = new ArrayList(); 
		list.add(Integer.valueOf(1));
		list.add(new String("2"));
		
		Integer i = (Integer)list.get(0);
		
		/* generic case */
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(Integer.valueOf(1));
		intList.add(3);					// autoBoxing (int -> Integer)
		//intList.add(new String("2")); // String은 거른다
		int intVal = intList.get(0); 	// autoUnboxing(Integer -> int)
		
	}
	
	
}
