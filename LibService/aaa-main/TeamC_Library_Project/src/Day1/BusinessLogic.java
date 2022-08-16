package Day1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class BusinessLogic {

	public void borrowBook(int stdNo, int bookNo) throws SQLException {
		BorrowBook bb = new BorrowBook(stdNo, bookNo);
		
		boolean checkSuspention 	= bb.checkSuspention();;
		boolean checkUnReturnBook 	= bb.checkUnreturnBook();
		boolean checkBorrowable		= bb.checkBorrowable();
		boolean checkHaveBook		= bb.checkHaveBook();
		
		if(checkSuspention == true) {
			System.out.println("대출정지된 학생입니다.");
			return;
		}
		
		if(checkUnReturnBook == true){ 
			System.out.println("미반납도서 중 연체도서가 있습니다.");
			return;
		}
		
		if(!checkBorrowable) {
			System.out.println("도서대여는 5권까지 가능합니다.");
			return;
		}
		
		if(checkHaveBook) {
			bb.borrowConfirm();
			System.out.println("대여 완료되었습니다");
		} else {
			System.out.println("해당 도서는 모두 대출 중입니다");
		}
	}
	
	public boolean borrowCondition(int stdNo, int bookNo) throws SQLException {
		BorrowBook bb = new BorrowBook(stdNo, bookNo);
		boolean flag = false;
		
		boolean checkSuspention 	= bb.checkSuspention();;
		boolean checkUnReturnBook 	= bb.checkUnreturnBook();
		boolean checkBorrowable		= bb.checkBorrowable();
		boolean checkHaveBook		= bb.checkHaveBook();
		
		if(checkSuspention == true) {
			System.out.println("대출정지된 학생입니다.");
			return false;
		}
		
		if(checkUnReturnBook == true){ 
			System.out.println("미반납도서 중 연체도서가 있습니다.");
			return false;
		}
		
		if(checkBorrowable == false) {
			System.out.println("도서대여는 5권까지 가능합니다.");
			return false;
		}
		
		if(checkHaveBook == false) {
			System.out.println("해당 도서는 모두 대출 중입니다");
			return false;
		}
		flag = true;
		return flag;
		
	}//borrowCondition
	
	
	public void returnBook(int stdNo, int bookNo) throws SQLException {
		ReturnBook rb = new ReturnBook(stdNo, bookNo);
		boolean unborrowable = rb.checkUnreturnBook();
		boolean returnable = rb.checkHaveBook();
		
		if (!unborrowable) {
			if (returnable) {
				System.out.println("도서반납이 완료되었습니다.");
				rb.returnConfirm();
			}
		} else {
			unborrowable = rb.checkSuspension();
			if (unborrowable) {
				System.out.println("대출정지일자가 갱신되었습니다.");
				rb.updateSuspension();
				rb.returnConfirm();
			} else {
				System.out.println("대출정지일자가 추가되었습니다.");
				rb.newSuspension();
				rb.returnConfirm();
			}
		}

	}//returnBook
	
	
	
	
	public static void autoTransaction() {
		LibraryDAO dao = new LibraryDAO();
		
		String sqlSt 		= "select std_no from studenttbl";
		String sqlBk 		= "select book_no from booktbl";

		String sql			= "insert into loanTBL(loan_date,exp_return_date,std_no,book_no,return_date,return_yn) "
							+ "values ("
							+ "?"  //loanDate
							+ ",?" //expDate
							+ ",?" //stdno
							+ ",?" //bookno
							+ ",?" //returnDate
							+ ",?)";

		String sqlCnt		= "update studentTBL "
							+ "set loan_cnt = loan_cnt+1 "
							+ "where std_no = ?";
		
		
		Connection con = ConnectionManager.getConnection();
		
		try {
			
			PreparedStatement pstmtSt = con.prepareStatement(sqlSt);
			ResultSet rsSt = pstmtSt.executeQuery();
			
			ArrayList<Integer> listSt = new ArrayList<Integer>();
			while(rsSt.next()) {
				listSt.add(rsSt.getInt("std_no"));
			}
			
			PreparedStatement pstmtBk = con.prepareStatement(sqlBk);
			ResultSet rsBk = pstmtBk.executeQuery();
			
			ArrayList<Integer> listBk = new ArrayList<Integer>();
			while(rsBk.next()) {
				listBk.add(rsBk.getInt("book_no"));
			}
			
			/* 1/6은 반납하지 않음 */
			ArrayList<String> listYn = new ArrayList<String>();
			for(int i = 0; i < 5; i++) {
				listYn.add("Y");
			}
			listYn.add("N");
			
			BusinessLogic bl = new BusinessLogic();
			boolean flag = bl.borrowCondition(listSt.get((int)((Math.random()*(listSt.size())))), listBk.get((int)((Math.random()*(listSt.size())))));
			
			if(flag == false) {
				autoTransaction();
			}
			
			PreparedStatement pstmtInsert = con.prepareStatement(sql);
			PreparedStatement cntInsert = con.prepareStatement(sqlCnt);
			
			for(int i=0; i<500; i++) {
				String now	 		= DateTimeService.getNow();
				String loanDate		= DateTimeService.calDate(now, (int)(Math.random()*14));
				String expDate 		= DateTimeService.calDate(loanDate, 7);
				int stdNum = listSt.get((int)((Math.random()*(listSt.size()))));
				//String returnDate	= DateTimeService.calDate(loanDate, (int)(Math.random()*10));
				pstmtInsert.setString(1, loanDate);
				pstmtInsert.setString(2, expDate);
				pstmtInsert.setInt(3, stdNum);
				pstmtInsert.setInt(4, listBk.get((int)((Math.random()*(listSt.size())))));
				pstmtInsert.setString(5, DateTimeService.calDate(now, (int)(Math.random()*21)));
				//pstmtInsert.setString(5,  null);
				pstmtInsert.setString(6,  "Y");
				//pstmtInsert.setString(6, listYn.get((int)(Math.random()*(listYn.size()))));
				cntInsert.setInt(1, stdNum);
				pstmtInsert.executeQuery();
				cntInsert.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//autoTransaction
	
	
	
}
