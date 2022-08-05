package proto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibMain {
	/* field */
	
	/* MAIN */
	public static void main(String[] args) {
		LibMain main = new LibMain();
//		main.bkLoader(); 최초 1회 로드 
//		main.stLoader(); 최초 1회 로드 
		main.result00();
		main.result01();
		main.result02();
		main.result03();
		main.result04();
		main.result05();
		main.result06();
		
		try {
			main.borrowBook(20162741, 3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
	/* methods */
	public void stLoader() {
		LoadFile fl = new LoadFile();
		try {
			ArrayList<StudentVO> stlist = fl.getStudentFile();
			StudentDAO sdao = new StudentDAO();
			try {
				sdao.insertStData(stlist);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// Load StudentVO
	
	public void bkLoader() {
		LoadFile fl = new LoadFile();
		try {
			ArrayList<BookVO> blist = fl.getBookFile();
			BookDAO bdao = new BookDAO();
			try {
				bdao.insertBookData(blist);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// Load BookVO
	
	// 대출 
	public void borrowBook(int stdNo, int bookNo) throws SQLException {
		LibBusiness lb = new LibBusiness();
		lb.Borrow(stdNo, bookNo);
	}
	
	
	public void result00() {
		LibBusiness lb = new LibBusiness();
		lb.solution00();
	}
	
	public void result01() {
		LibBusiness lb = new LibBusiness();
		lb.solution01();
	}
	
	public void result02() {
		LibBusiness lb = new LibBusiness();
		lb.solution02();
	}
	
	public void result03() {
		LibBusiness lb = new LibBusiness();
		lb.solution03();
	}
	
	public void result04() {
		LibBusiness lb = new LibBusiness();
		lb.solution04();
	}

	public void result05() {
		LibBusiness lb = new LibBusiness();
		lb.solution05();
	}
	
	public void result06() {
		LibBusiness lb = new LibBusiness();
		lb.solution06();
	}// end result
	
	
	
}
