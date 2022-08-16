package Day1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainU {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InfoBook ib = new InfoBook();
		try {
			ib.searchBook("가나다라");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void bookstatus() throws SQLException {
		Scanner scan = new Scanner(System.in);
		boolean isStop = false;
		BusinessLogic bl = new BusinessLogic();
		int bookNo;
		int stuNo;
		while (!isStop) {
			System.out.println("1. 도서정보 | 2. 도서대여 | 3. 도서반납 | 4. 이용정보 | 5. 종료");
			System.out.print("메뉴 중 하나를 선택하세요 >>> ");
			
			int cmd = scan.nextInt();
			// 선택에 맞는 작업을 한다.
			switch(cmd) {
			case 1:
				InfoBook ib = new InfoBook();
				System.out.println("1. 도서현황 | 2. 도서등록 | 3. 책정보수정 | 4. 종료.");
				System.out.print("메뉴 중 하나를 선택하세요 >>> ");
				int cmd2 = scan.nextInt();
				switch(cmd2) {
				case 1:
					ib.bookList();
//					System.out.println("도서목록");
//					ArrayList<BookVO> list = dao.selectBook();
//					System.out.println(list);
					isStop = true;
					
					break;
				case 2:
					isStop = true;
					System.out.println("책 정보를 입력하세요.");
					ib.bookAdd();
					break;
				case 3:
					isStop = true;
					ib.updateBook();
					System.out.print("수정 할 책의 번호를 입력해주세요.");
					break;
				case 4:
					isStop = true;
					System.out.println("감사합니다.");
				}
				break;
			case 2:
				System.out.println("대여목록");
				
				System.out.println("분류번호|    도서명      |    저자    |");
				System.out.println("7301	야쿠자의 덕질1	   야츠다테키");
				System.out.println("7302	헤어질 결심 각본   박찬욱");
				System.out.println("7303	계속 가보겠습니다  임은정");
				System.out.println("7304	불편한 편의점2	   김호연	");
				System.out.println("7305	   흔한남매	   백난도	");
				System.out.println("7306	   역행자	       자청	");
				System.out.println("7307	   삶의격	       파스칼");
				System.out.println("7308	   튜브	       손원평	");
				System.out.println("7309	   자유	       조너선	");
				System.out.println("7310	  저주토끼	   정보라");
				System.out.println("7311	  인간실격	   다자이오사무");
				System.out.println("7312	  아노말리	   에르베르텔리에");
				System.out.println("7313	    류	       히가시야마아키라");
				System.out.println("7314	  비올레트	   발레리페랭");
				System.out.println("7315	   모비딕	       허먼멘빌");
				System.out.println("7316	   데미안	       헤르만헤세");
				System.out.println("7317	  베이비토크	   샐리워드");
				System.out.println("7318	   하얼빈	       김훈");
				System.out.println("7319	   미키7	       에드워드애슈턴");
				System.out.println("7320     유럽도시기행2	   유시민");
				System.out.println("7321	 하쿠다사진관	   허태연");
				System.out.println("7322	 해커스 토익	   데이비드초");
				System.out.println("7323	  악어의눈물	   키스포크너");
				System.out.println("7324	 출생의 비밀	   홍성식");
				System.out.println("7325	 묘사하는마음	   김혜리");
				System.out.println("7326	  작별인사       김영하");
				System.out.println("7327	 미움받을용기	   기시미이치로");
				System.out.println("7328	5가지사랑의언어	   게리채프먼");
				System.out.println("7329	 밥상머리교육	   김정진");
				System.out.println("7330	    몰입	       황농문");
				
				System.out.println("대여하실 책의 번호를 입력해주세요>>");
				bookNo = scan.nextInt();
				System.out.println("학생번호를 입력해주세요 >>");
				stuNo = scan.nextInt();
				bl.borrowBook(stuNo, bookNo);
				break;
				
			case 3:
				System.out.println("도서반납.");
				System.out.println("");
				System.out.println("반납하실 책의 번호를 입력해주세요>>");
				bookNo = scan.nextInt();
				System.out.println("학생번호를 입력해주세요 >>");
				stuNo = scan.nextInt();
				bl.returnBook(stuNo, bookNo);
				break;
		
			case 4:
				System.out.println("1. 대출 도서 상위 5위에 대한 정보");
				System.out.println("2. 대출자 상위 5위에 대한 정보 ");
				System.out.println("3. 대출기간이 가장 짧은 도서에 대한 정보");
				System.out.println("4. 대출반납이 가장 빠른 학생");
				System.out.println("5. 대출을 가장 많이하는 학과");
				System.out.println("6. 대출반납이 가장 늦은 학과");
				System.out.println("7. 종료.");
				System.out.println("메뉴 중 하나를 선택하세요 >>> ");
				int cmd3 = scan.nextInt();
				switch(cmd3) {
				case 1:
					isStop = true;
					System.out.println(" 대출 도서 상위 5위에 대한 정보");
					break;
				case 2:
					isStop = true;
					System.out.println("대출자 상위 5위에 대한 정보");
					break;
				case 3:
					isStop = true;
					System.out.println("대출기간이 가장 짧은 도서에 대한 정보");
					break;
				case 4:
					isStop = true;
					System.out.println("대출반납이 가장 빠른 학생");
					break;
				case 5:
					isStop = true;
					System.out.println("대출을 가장 많이하는 학과");
					break;
				case 6:
					isStop = true;
					System.out.println("대출반납이 가장 늦은 학과");
					break;
				case 7:
					isStop = true;
					System.out.println("이용해주셔서 감사합니다.");
					break;
				}
				break;
				
			case 5:
				isStop = true;
				System.out.println("이용해주셔서 감사합니다.");
				break;
			}
		}
		scan.close();		
	}

}
