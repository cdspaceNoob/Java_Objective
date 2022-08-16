package Day1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class InfoBook {

	// 1. 도서 목록
	public void bookList() throws SQLException {
		LibraryDAO dao = new LibraryDAO();
		ArrayList<BookVO> list = dao.selectBook();

		for (BookVO vo : list) {
			System.out.println(vo.getBook_name());
		}
	}

	// 2. 도서 등록
	public void bookAdd() {

	}

	// 3.책 정보 수정
	public void updateBook() throws SQLException {
		Scanner sc = new Scanner(System.in);
		LibraryDAO dao = new LibraryDAO();
		while (true) {
			System.out.println("수정 할 책의 번호를 입력해주세요");
			int temp = Integer.parseInt(sc.nextLine());
			int book_no;
			String title;
			String author;
			boolean flag;
			System.out.println("책번호 입력: ");
			book_no = sc.nextInt();
			System.out.println("제목 입력: ");
			title = sc.nextLine();
			System.out.println("지은이 입력: ");
			author = sc.nextLine();
			flag = dao.updateBookInfo(temp, book_no, title, author);
			if (flag) {
				System.out.println("도서 수정 완료");
				break;
			} else {
				System.out.println("해당 도서가 존재하지 않습니다. 도서 번호를 다시 입력하세요.");
			}

		}
	}

	// 4. 도서 조회
	public void searchBook(String bookTitle) throws SQLException {
		LibraryDAO ldao = new LibraryDAO();
		boolean result = ldao.searchBook(bookTitle);
		if(result) {
			System.out.println("소장중인 도서입니다");
		}else {
			System.out.println("없는 도서입니다");
		}
	}//searchBook()

}