package lesson.day0718;

public class ObjectTest {
	public void compareTest() {
		int a = 10;
		int b = 10;
		
		if( a==b) {
			System.out.println("a==b");
		}else {
			System.out.println("a!=b");
		}
	}
	
	public void compareTest2() {
		String a = new String(); // 아무 것도 없는 문자열 생성 
								 // 공백 문자열이 존재하므로 에러는 아니다
		String b = new String("10");
		String c = new String("10");
		System.out.println("object");
		System.out.println(b.toString());
		if(b == c) {
			System.out.println("b==c");
		}else {
			System.out.println("b!=c");
		}
		/* equals()는 리터럴이 동일한지 체크한다 */
		if(b.equals(c)) {
			System.out.println("equals");
		}else {
			System.out.println("not equals");
		}
	}
	
	public void compareTest3() {
		String a = "10";
		String b = "10";
		System.out.println("literal");
		if(a==b) {
			System.out.println("a==b");
		}else {
			System.out.println("a!=b");
		}
		
		if(a.equals(b)) {
			System.out.println("equals");
		}else {
			System.out.println("not equals");
		}
	}
	
	
}
