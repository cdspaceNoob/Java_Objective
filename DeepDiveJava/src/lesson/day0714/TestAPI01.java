package lesson.day0714;

import java.util.Scanner;

public class TestAPI01 {
	public void TestAPI01() {
		System.out.println("input>>");
		Scanner scan = new Scanner(System.in); 
		/* 생성자 파라미터에 정보를 줘야 한다 -> 이런 경우 객체 생성 자체가 아니 됨 '필수'이므로 */
		/* Scanner: 외부로부터 데이터를 입력받는 방법 */
		/* java I.O Stream은 해줘야할 것들이 많다  */
		String cmd = scan.nextLine();
		System.out.println(cmd);
		scan.close();
		/* Scanner는 쓰고 나면 닫아준다 */ 
	}
}
