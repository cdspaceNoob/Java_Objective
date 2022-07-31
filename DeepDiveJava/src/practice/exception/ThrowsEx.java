package practice.exception;

public class ThrowsEx {
	public static void main(String[] args) {
		try {
			findClass(); // ClassNotFoundException을 유발할 수 있는 메소드를 실행하므로, try-catch
		} catch(ClassNotFoundException e) {
			System.out.println("존재하지 않는 클래스입니다");
		}	
	}
	
	/* method */
	public static void findClass() throws ClassNotFoundException {
		Class clazz = Class.forName("java.lang.String2"); // 예외 발생이 예상되므로 throws 처리한다 
	}
}
