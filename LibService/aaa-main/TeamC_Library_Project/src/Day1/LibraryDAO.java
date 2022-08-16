package Day1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class LibraryDAO {
	
	//도서 검색 
	public boolean searchBook(String bookTitle) throws SQLException {
		boolean flag =  false;
		Connection con = ConnectionManager.getConnection();
		
		String sql = "select book_name from bookTBL where book_name like "+"'%"+bookTitle+"%'";
		
		//쿼리 체크 
		//System.out.println(sql); 
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			String title = rs.getString(1).replaceAll(" ","");
			System.out.println("쿼리로 가져온 타이틀: "+title);
			System.out.println("파라미터로 받은 타이틀: "+bookTitle.replaceAll(" ",""));
			if(title.equals(bookTitle.replaceAll(" ",""))) {
				flag = true;
			}
		}
		System.out.println(flag);
		return flag;
	}
	
	//대출장부 추가
	public boolean insertRentalBook(ArrayList<LoanVO> list) throws SQLException {
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		String sql = "insert into loanTBL(loan_date,exp_return_date,std_no,book_no,return_date,return_yn) values (?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		int affectedCount = 0;
		for(LoanVO vo : list) {
			
			pstmt.setString(1, vo.getLoan_date());
			pstmt.setString(2, vo.getExp_return_date());
			pstmt.setInt(3, vo.getStd_no());
			pstmt.setInt(4, vo.getBook_no());
			pstmt.setString(5, vo.getReturn_date());
			pstmt.setString(6, vo.getReturn_yn());
			affectedCount = pstmt.executeUpdate();
		}
		if (affectedCount>0) {
			flag = true;
		}
		ConnectionManager.closeConnection(null, pstmt, con);
		System.out.println("대출장부 추가");
		return flag;
	}
	//예약장부 추가
	public boolean insertReserveBook(ArrayList<ReservationVO> list) throws SQLException {
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		String sql = "insert into rsvsTBL(rsvs_date,std_no,book_no,rsvs_yn) values (?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		int affectedCount = 0;
		for(ReservationVO vo : list) {
			pstmt.setString(1, vo.getRsvs_date());
			pstmt.setInt(2, vo.getStd_no());
			pstmt.setInt(3, vo.getBook_no());
			pstmt.setString(4, vo.getRsvs_yn());
			affectedCount = pstmt.executeUpdate();
		}
		if (affectedCount>0) {
			flag = true;
		}
		ConnectionManager.closeConnection(null, pstmt, con);
		System.out.println("예약장부 추가");
		return flag;
	}
	//대출장부 전체 조회
	public ArrayList<LoanVO> selectRentalBook() throws SQLException {
		ArrayList<LoanVO> list = new ArrayList<LoanVO>();
		Connection con = ConnectionManager.getConnection();
		String sql = "select * from loanTBL";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		LoanVO vo = null;
		while (rs.next()) {
			vo = new LoanVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),
					rs.getInt(5),rs.getString(6),rs.getString(7));
			list.add(vo);
		}
		ConnectionManager.closeConnection(rs, pstmt, con);
		return list;
	}
	//학번으로 대출장부 조회
	public ArrayList<LoanVO> selectRentalBook(int std_no) throws SQLException {
		ArrayList<LoanVO> list = new ArrayList<LoanVO>();
		Connection con = ConnectionManager.getConnection();
		String sql = "select * from loanTBL where std_no=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, std_no);
		ResultSet rs = pstmt.executeQuery();
		LoanVO vo = null;
		while (rs.next()) {
			vo = new LoanVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),
					rs.getInt(5),rs.getString(6),rs.getString(7));
			list.add(vo);
		}
		ConnectionManager.closeConnection(rs, pstmt, con);
		return list;
	}
	//예약장부 조회
	public ArrayList<ReservationVO> selectReserveBook() throws SQLException {
		ArrayList<ReservationVO> list = new ArrayList<ReservationVO>();
		Connection con = ConnectionManager.getConnection();
		String sql = "select * from rsvsTBL";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		ReservationVO vo = null;
		while (rs.next()) {
			vo = new ReservationVO(rs.getInt(1),rs.getString(2),rs.getInt(3),
					rs.getInt(4),rs.getString(5));
			list.add(vo);
		}
		ConnectionManager.closeConnection(rs, pstmt, con);
		return list;
	}
	//학생정보 조회
	public ArrayList<StudentVO> selectStudent() throws SQLException {
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
		Connection con = ConnectionManager.getConnection();
		String sql = "select * from studentTBL";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		StudentVO vo = null;
		while (rs.next()) {
			vo = new StudentVO(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4),
					rs.getInt(5),rs.getInt(6),rs.getString(7));
			list.add(vo);
		}
		ConnectionManager.closeConnection(rs, pstmt, con);
		return list;
	}
	//학번으로 학생정보 조회
	public StudentVO selectStudent(int std_no) throws SQLException {
		StudentVO vo = null;
		Connection con = ConnectionManager.getConnection();
		String sql = "select * from studentTBL where std_no = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, std_no);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			vo = new StudentVO(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4),
					rs.getInt(5),rs.getInt(6),rs.getString(7));
		}
		ConnectionManager.closeConnection(rs, pstmt, con);
		return vo;
	}
	//도서정보 조회
	public ArrayList<BookVO> selectBook() throws SQLException {
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		Connection con = ConnectionManager.getConnection();
		String sql = "select * from bookTBL";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		BookVO vo = null;
		while (rs.next()) {
			vo = new BookVO(rs.getInt(1),rs.getString(2),rs.getString(3),
					rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7));
			list.add(vo);
		}
		ConnectionManager.closeConnection(rs, pstmt, con);
		return list;
	}
	//책 분류로 도서정보 조회
	public BookVO selectBook(int book_no) throws SQLException {
		BookVO vo = null;
		Connection con = ConnectionManager.getConnection();
		String sql = "select * from bookTBL where book_no = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, book_no);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			vo = new BookVO(rs.getInt(1),rs.getString(2),rs.getString(3),
					rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7));
		}
		ConnectionManager.closeConnection(rs, pstmt, con);
		return vo;
	}
	
	//학번으로 예약정보 조회
	public ArrayList<ReservationVO>  selectStudentReserveList(int std_no) throws SQLException {
		ArrayList<ReservationVO> list = new ArrayList<ReservationVO>();
		Connection con = ConnectionManager.getConnection();
		String sql = "select * from rsvsTBL where std_no = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, std_no);
		ResultSet rs = pstmt.executeQuery();
		ReservationVO vo = null;
		while (rs.next()) {
			vo = new ReservationVO(rs.getInt(1),rs.getString(2), rs.getInt(3),rs.getInt(4),rs.getString(5));
			list.add(vo);
		}
		ConnectionManager.closeConnection(rs, pstmt, con);
		return list;
	}

	//대여가능여부 갱신
	public boolean updateRentalBook(String loan_yn, int book_no) throws SQLException {
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		Statement stmt = null;
		DateTimeService dt = new DateTimeService();
		stmt = con.createStatement();
		String sql1 = "update studentTBL set loan_cnt = loan_cnt - 1 where "
				+ "std_no = (SELECT std_no FROM loantbl where return_yn = 'N' and book_no = "+book_no+")";
		String sql2 = "update bookTBL set loan_yn='"+loan_yn+"' where book_no="+ book_no;
		String sql3 = "update loantbl set return_yn = 'Y' ,return_date ="+dt.getNow()+" where return_yn = 'N' and book_no = "+book_no;
		int affectedCount = stmt.executeUpdate(sql1);
		int affectedCount2 = stmt.executeUpdate(sql2);
		int affectedCount3 = stmt.executeUpdate(sql3);
		if (affectedCount>0 && affectedCount2 > 0 && affectedCount3 > 0) {
			flag = true;
		}
		ConnectionManager.closeConnection(null, stmt, con);
		return flag;
	}
	
	//학번으로 대출정지일 갱신
	public boolean updateStudentStopRentalDate(int book_no, int std_no) throws SQLException {
		DateTimeService dt = new DateTimeService();
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		Statement stmt = null;
		String sql = "update studentTBL "
					+ "set stop_date = cast(date_format(datediff(cast("+dt.getNow()+" as datetime),"
					+ "cast((select return_date from loanTBL where book_no = "+book_no+") as datetime))"
					+ "as varchar(8))) "
					+ "where book_no="+ std_no;

		stmt = con.createStatement();
		int affectedCount = stmt.executeUpdate(sql);
		if (affectedCount>0) {
			flag = true;
		}
		ConnectionManager.closeConnection(null, stmt, con);
		return flag;
	}
	
	//학번으로 예약권수 갱신
	public boolean updateStudentReserveCnt(int std_no) throws SQLException {
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		Statement stmt = null;
		String sql = "update studentTBL "
					+ " set rsvs_cnt = rsvs_cnt - 1 "
					+ " where std_no = "+std_no;

		stmt = con.createStatement();
		int affectedCount = stmt.executeUpdate(sql);
		if (affectedCount>0) {
			flag = true;
		}
		ConnectionManager.closeConnection(null, stmt, con);
		return flag;
	}
	//학번으로 대출권수 갱신
	public boolean updateStudentRentalCnt(int std_no) throws SQLException {
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		Statement stmt = null;
		String sql = "update studentTBL "
					+ "set loan_cnt = loan_cnt +1 "
					+ "where std_no = "+std_no;

		stmt = con.createStatement();
		int affectedCount = stmt.executeUpdate(sql);
		if (affectedCount>0) {
			flag = true;
		}
		ConnectionManager.closeConnection(null, stmt, con);
		return flag;
	}
	//책번호로 예약인원 갱신
	public boolean updateBookReserveCnt(int book_no) throws SQLException {
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		Statement stmt = null;
		String sql = "update bookTBL "
					+ "set rsvs_people = rsvs_people +1 "
					+ "where book_no = "+book_no;

		stmt = con.createStatement();
		int affectedCount = stmt.executeUpdate(sql);
		if (affectedCount>0) {
			flag = true;
		}
		ConnectionManager.closeConnection(null, stmt, con);
		return flag;
	}
	public boolean updateBookInfo(int ex_book_no,int book_no,String book_name, String writer) throws SQLException {
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		Statement stmt = null;
		String sql = "update bookTBL "
		+"set book_no ="+book_no+",book_name='"+book_name+"',writer='"+writer + "'"
		+" where book_no = "+ex_book_no;
		stmt = con.createStatement();
		int affectedCount = stmt.executeUpdate(sql);
		if (affectedCount>0) {
		flag = true;
		}
		ConnectionManager.closeConnection(null, stmt, con);
		return flag;
		}


}