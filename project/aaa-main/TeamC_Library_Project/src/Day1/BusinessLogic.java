package Day1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class BusinessLogic {

	public void borrowBook(int stuNo, int bookNo) throws SQLException {
		BorrowBook bb = new BorrowBook(stuNo, bookNo);
//		boolean borrowable = false;
		
		boolean checkSuspention 	= bb.checkSuspention();;
		boolean checkUnReturnBook 	= bb.checkUnreturnBook();
		boolean checkBorrowable		= bb.checkBorrowable();
		boolean checkHaveBook		= bb.checkHaveBook();
		
		if(!checkSuspention) {
			System.out.println("대출정지된 학생입니다.");
			return;
		}
		
		if(!checkUnReturnBook){
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
		

//		borrowable = bb.checkSuspention();
//		if (borrowable) {
//			bb.borrowCancell();
//			System.out.println("대출정지된 학생입니다.");
//		} else {
//			borrowable = bb.checkUnreturnBook();
//			if (borrowable) {
//				bb.borrowCancell();
//				System.out.println("미반납도서 중 연체도서가 있습니다.");
//			} else {
//				borrowable = bb.checkBorrowable();
//				if (!borrowable) {
//					bb.borrowCancel();
//					System.out.println("도서대여는 5권까지 가능합니다.");
//				} else {
//					borrowable = bb.checkHaveBook();
//					if (borrowable) {
//						bb.borrowConfirm();
//						System.out.println("도서대여가 완료되었습니다.");
//					} else {
//						System.out.println("해당 도서는 모두 대여중 입니다. 예약하시겠습니까?  >> Y/N");
//						Scanner scan = new Scanner(System.in);
//						String choice = scan.nextLine();
//						scan.close();
//						if (choice.toUpperCase().equals("Y")) {
//							Boolean reservationable = false;
//							ReservationBook rb = new ReservationBook(stuNo, bookNo);
//							reservationable = rb.checkReservationableStu();
//							if (!reservationable) {
//								rb.reservationCancell();
//								System.out.println("도서예약은 3권까지 가능합니다.");
//							} else {
//								reservationable = rb.checkReservationableBook();
//								if (!reservationable) {
//									rb.reservationCancell();
//									System.out.println("해당 도서의 예약인원은 2명까지 가능합니다.");
//								} else {
//									reservationable = rb.checkLoanOrRsrv();						
//									if (reservationable) {
//										rb.reservationCancell();
//										System.out.println("학생이 해당 도서를 이미 대여 또는 예약 중 입니다.");
//									} else {
//										rb.reservationConfirm();
//										System.out.println("도서예약이 완료되었습니다.");
//									}
//								}
//							}
//						} else if (choice.equals("N")) {
//							bb.borrowCancell();
//							System.out.println("도서 대여 및 예약이 취소되었습니다.");
//						}
//					}
//				}
//			}
//		}
	}
	
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
//		String now	 		= DateTimeService.getNow();
//		String loanDate		= DateTimeService.calDate(now, (int)(Math.random()*14));
//		String expDate 		= DateTimeService.calDate(loanDate, 7);
//		String returnDate	= DateTimeService.calDate(loanDate, (int)(Math.random()*10));

//		String pattern = "yyyy-MM-dd";
//		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//		String loanDateP = sdf.format(loanDate);
//		String expDateP = sdf.format(expDate);
//		String returnDateP = sdf.format(returnDate);
		
		String sqlSt 		= "select std_no from studenttbl";
		String sqlBk 		= "select book_no from booktbl";
		
//		String sql			= "insert into loanTBL(loan_date,exp_return_date,std_no,book_no,return_date,return_yn) "
//							+ "values ("
//							+ "'"+loanDate + "'"
//							+ ", '" + expDate + "'"
//							+ ",?" //stdno
//							+ ",?" //bookno
//							+ ", '" + returnDate + "'"
//							+ ",?)";
		String sql			= "insert into loanTBL(loan_date,exp_return_date,std_no,book_no,return_date,return_yn) "
							+ "values ("
							+ "?"  //loanDate
							+ ",?" //expDate
							+ ",?" //stdno
							+ ",?" //bookno
							+ ",?" //returnDate
							+ ",?)";
//		System.out.println("loandate="+loanDate);
//		System.out.println("expdate="+expDate);
//		System.out.println("returnDate="+returnDate);
		
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
			
			PreparedStatement pstmtInsert = con.prepareStatement(sql);
			
			for(int i=0; i<500; i++) {
				String now	 		= DateTimeService.getNow();
				String loanDate		= DateTimeService.calDate(now, (int)(Math.random()*14));
				String expDate 		= DateTimeService.calDate(loanDate, 7);
				//String returnDate	= DateTimeService.calDate(loanDate, (int)(Math.random()*10));
				pstmtInsert.setString(1, loanDate);
				pstmtInsert.setString(2, expDate);
				pstmtInsert.setInt(3, listSt.get((int)((Math.random()*(listSt.size())))));
				pstmtInsert.setInt(4, listBk.get((int)((Math.random()*(listSt.size())))));
				//pstmtInsert.setString(5, returnDate);
				pstmtInsert.setString(5,  null);
				//pstmtInsert.setString(6,  "N");
				pstmtInsert.setString(6, listYn.get((int)(Math.random()*(listYn.size()))));
				pstmtInsert.executeQuery();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//autoTransaction
	
	
	
}
