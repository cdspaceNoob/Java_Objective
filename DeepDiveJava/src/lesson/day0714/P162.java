package lesson.day0714;
import java.util.Scanner;
public class P162 {
	Scanner scan = new Scanner(System.in);
	public void teller() {
		int deposit = 0;
		boolean checker = true;
		while(true) {
			if(!checker) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			System.out.println("---------------------------------");
			System.out.println("1.예금 | 2.출금 | 3. 잔고 | 4. 종료  |");
			System.out.println("---------------------------------");
			System.out.print("선택>> ");
			int menu = client();
			
			switch(menu) {
			case 1:
				System.out.print("예금액>> ");
				deposit += client();
				System.out.println();
//				continue;
				break;
			case 2:
				System.out.print("출금액>> ");
				deposit -= client();
				System.out.println();
//				continue;
				break;
			case 3:
				System.out.println("잔고>> "+deposit);
				System.out.println();
//				continue;
				break;
			case 4:
				System.out.println("프로그램 종료");
				checker = false;
//				continue;
				break;
			}
		}
	}
	
	
	
	public int client() {
		return scan.nextInt();
	}
}
