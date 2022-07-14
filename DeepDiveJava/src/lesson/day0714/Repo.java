package lesson.day0714;

import java.util.Scanner;

public class Repo {
	// 메뉴 준다
	// 입력 받는다
	
	// 예금 기능
	// 출금 기능
	// 잔고 학인 기능
	
	// 종료
	public void menu() {
		while(true) {
			System.out.println("---------------------------------");
			System.out.println("1.예금 | 2.출금 | 3. 잔고 | 4. 종료  |");
			System.out.println("---------------------------------");
			System.out.print("선택>> ");
			Scanner scan = new Scanner(System.in);
			int input = scan.nextInt();
			
			
			switch(input) {
			case 1:
				printer(input);
			case 2:
				printer(input);
			case 3:
				printer(input);
			case 4:
				break;
			}
		}
	}
	
	
//	public int depoIn(int input, int deposit) {
//		int result = 0;
//		result = deposit+input;
//		return result;
//	}
//	
//	
//	public int depoOut(int input, int deposit) {
//		int result = 0;
//		result = deposit-input;
//		return result;
//	}
//	
//	
//	public int depoCheck(int input, int deposit) {
//		int result = 0;
//		result = deposit;
//		return result;
//	}
	
	
	public void printer(int input) {
		switch(input) {
		case 1:
			System.out.print("예금액>");
			Scanner scan = new Scanner(System.in);
			break;
		case 2:
			System.out.print("출금액>");
			Scanner scan02 = new Scanner(System.in);
			int money02 = scan02.nextInt();
			break;
		case 3:
			System.out.print("잔고>");
			Scanner scan03 = new Scanner(System.in);
			int money03 = scan03.nextInt();
			break;
		}
		
	}
	
}
