package lesson.day0720;

public class TestMain {
	// 공개 범위: 전체 
	// 클래스 정적 메소드: 객체 없이 접근 및 실행
	// 리턴 타입 없음 
	// 매개변수는 문자열 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestMain tm = new TestMain();
		tm.test1(args); // argument: 실질적인 값을 가진 것 
		tm.test2(args);
		tm.test3();
		tm.test4();
		
	
	}/* end main */
	
	
	public void test1(String[] args) { // param: 선언 요소 
		try {
			/* args를 어떻게 받을 수 있을까 */
			/* static void main과 동일하게 파라미터로 전달한다 */
			System.out.println(args[0]);
			System.out.println(args[1]);	
		}catch(ArrayIndexOutOfBoundsException io){
			System.out.println("다음과 같은 인덱스 에러가 있습니다\n"+io.getMessage());
			io.printStackTrace();
		}
	}/* end test1 */
	
	
	public void test2(String[] args) {
		for(int i=0; i<args.length; i++) {
			System.out.println(args[i]);
		}
	}/* end test2 */
	
	
	public void test3() {
		TestCode tc = new TestCode();
		tc.testDate();
	}/* end test3 */
	
	
	public void test4() {
		DateTimeService dts = new DateTimeService();
		String now = dts.getDateTime(DateTimeService.DATE_ONLY);
		System.out.print("new "+now);
		
	}
	
	
	
}/* END CLASS */

