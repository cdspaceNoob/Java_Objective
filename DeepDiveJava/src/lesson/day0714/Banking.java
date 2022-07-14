package lesson.day0714;
import java.util.Scanner;
public class Banking {
	public void openBank() {
		Scanner scan = new Scanner(System.in);
		boolean isStop = false;
		while (!isStop) {
			// 메뉴을 보여준다.
			System.out.println("1. 입금 | 2. 출금 | 3. 잔액 | 4. 종료");
			// 선택을 기다린다.
			System.out.print("메뉴 중 하나를 선택하세요 >>> ");
			
			int cmd = scan.nextInt();
			// 선택에 맞는 작업을 한다.
			switch(cmd) {
			case 1:
				System.out.println("입금 처리.");
				break;
			case 2:
				System.out.println("출금 처리.");
				break;
			case 3:
				System.out.println("잔금 확인.");
				break;
			case 4:
				isStop = true;
				System.out.println("이용해 주셔서 감사합니다.");
				break;
			}
		}
		scan.close();
	}
}
	