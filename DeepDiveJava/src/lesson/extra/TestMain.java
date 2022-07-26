package lesson.extra;
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
	
	public static void test1() {
		TestMain tm2 = new TestMain();
		
		System.out.println(tm2.age);
		System.out.println(TestMain.firstname);
		System.out.println(tm2.firstname);
	}
}
