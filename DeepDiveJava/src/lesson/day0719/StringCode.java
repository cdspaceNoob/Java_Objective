package lesson.day0719;

public class StringCode {
	
	public void test3() {
		String data = "990001, addx, 17, 29, 16, 49, 43,154,C,A,C";
		data = data.trim();
		String[] temp = data.split(",");
		int size = temp.length;
		for(int i=0; i<size; i++) {
			System.out.println(temp[i].trim());
		}
	}
	
	
	public void test2() {
		String number = "12345";
		int sum = 0;
		for(int i=0; i<number.length(); i++) {
//			String letter = number.substring(i,i+1);
			char temp = number.charAt(i);
			String letter = String.valueOf(temp);
			sum = sum + Integer.parseInt(letter);
			System.out.println(letter);
		}
	}
	
	
	public void test1() {
		String data = "990001addx 17 29 16 49 43154CAC";
		/* 길이를 알고싶을 때: .length(); */
		int len = data.length(); 
		System.out.println(len);
		
		/* 문자열의 부분 추출: .substring(시작 인덱스, 끝 인덱스-1) */
		String stdNo = data.substring(0,6);
		System.out.println(stdNo);
		String kor = data.substring(10, 13);
		System.out.println(kor);
		
		/* 문자열을 숫자로 바꾸고 싶습니다: Intger.parseInt(문자열변수) */
//		int stdNoInt = Integer.parseInt(stdNo);
//		int korInt = Integer.parseInt(kor);
//		System.out.println(stdNoInt);
//		System.out.println(korInt);
		/* Exception in thread "main" java.lang.NumberFormatException: For input string: " 17" */
		/* 공백에 의한 에러 발생 */
		
		/* 문자열의 공백을 제거하고 싶읍니다: .trim() */
		int stdNoInt = Integer.parseInt(stdNo);
		int korInt = Integer.parseInt(kor.trim());
		System.out.println(stdNoInt);
		System.out.println(korInt);
		
		String math = data.substring(14, 16);
		System.out.println(math);
		String eng = data.substring(17, 19);
		System.out.println(eng);
		String history = data.substring(19, 22);
		System.out.println(history.trim());
		String science = data.substring(22, 25);
		System.out.println(science.trim());
		String total = data.substring(25, 28);
		System.out.println(total);
		String code1 = data.substring(28, 29);
		System.out.println(code1);
		String code2 = data.substring(29, 30);
		System.out.println(code2);
		String code3 = data.substring(30, 31);
		System.out.println(code3);
		
		
	}	
}
