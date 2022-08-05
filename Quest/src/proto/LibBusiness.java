package proto;

import java.sql.SQLException;
import java.util.ArrayList;

public class LibBusiness {
	
	
	// 도서 대출 가능여부 확인
	public void chekcer(int bookNo) throws SQLException {
		ListDAO ldao = new ListDAO();
	    boolean checker = ldao.checkBook(bookNo);
	    if(checker) {
	    	System.out.println("대출 가능한 도서입니다");
	    }else {
	    	System.out.println("현재 대출 중인 도서입니다");
	    }
	}
	
	// 도서 대출 
	public void Borrow(int stdNo, int bookNo) throws SQLException {
		ListDAO ldao = new ListDAO();
		ldao.insertList(stdNo, bookNo);
	}
	
	// 도서 반납
	public void giveBack(int bookNo) {
		ListDAO lado = new ListDAO();
		try {
			boolean checker = lado.giveBack(bookNo);
			if(checker) {
				System.out.println("반납했습니다");
			}else {
				System.out.println("반납 실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}//end class
	
	
	
	
//	0) 현재 대출중인 책의 정보, 대출자, 반납일, 연체여부에 대한 정보를 제공
//	public void solution00() throws SQLException {
//		ListDAO ldao = new ListDAO();
//		ldao.getData00();
//		}// end solution00
	
	//1) 대출 도서 상위 5위에 대한 정보
//	public void solution01() {
//		BookDAO bdao = new BookDAO();
//		StudentDAO stdao = new StudentDAO();
//		ListDAO ldao = new ListDAO();
//	}// end solution01
	
	//2) 대출자 상위 5위에 대한 정보
//	public void solution02() {
//		BookDAO bdao = new BookDAO();
//		StudentDAO stdao = new StudentDAO();
//		ListDAO ldao = new ListDAO();
//	}//end solution02
	
	//3) 대출기간이 가장 짧은 도서에 대한 정보
//	public void solution03() {
//		BookDAO bdao = new BookDAO();
//		StudentDAO stdao = new StudentDAO();
//		ListDAO ldao = new ListDAO();
//	}//end solution03
	
	//4) 대출반납이 가장 빠른 학생에 대한 정보
//	public void solution04() {
//		BookDAO bdao = new BookDAO();
//		StudentDAO stdao = new StudentDAO();
//		ListDAO ldao = new ListDAO();
//	}
	
	//5) 대출을 가장 많이 하는 학과에 대한 정보
//	public void solution05() {
//		BookDAO bdao = new BookDAO();
//		StudentDAO stdao = new StudentDAO();
//		ListDAO ldao = new ListDAO();
//	}
	
	//6) 대출반납이 가장 늦은 학과에 대한 정보
//	public void solution06() {
//		BookDAO bdao = new BookDAO();
//		StudentDAO stdao = new StudentDAO();
//		ListDAO ldao = new ListDAO();
//	}
//}// END OF THIS FILE
