package lesson.day0720;

public class TestMain {
	// 공개 범위: 전체 
	// 클래스 정적 메소드: 객체 없이 접근 및 실행
	// 리턴 타입 없음 
	// 매개변수는 문자열 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		try {
			System.out.println(args[0]);
			System.out.println(args[1]);	
		}catch(ArrayIndexOutOfBoundsException io){
			System.out.println("다음과 같은 인덱스 에러가 있습니다");
			io.printStackTrace();
		}
		

	}
}
