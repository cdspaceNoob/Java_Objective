package proto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ListDAO {
	

//	public void setList() throws SQLException {
//		Connection con = ConnectionManager.getConnection();
//		
//		String sqlSelct = "select stdNo from list";
//		PreparedStatement pstmtSelect = con.prepareStatement(sqlSelct);
////		pstmtSelect.setString(1, "stdNo");
//		ResultSet rs = pstmtSelect.executeQuery();
//		ArrayList list = new ArrayList();
//		int result = 0;
//		
//		while(rs.next()) {
//			result = rs.getInt(1);
//			list.add(result);
//		}
//		
//		System.out.print(list);
//		
//		String sqlInsert = "insert into list(stdNo, bookNo, dateOut, dateIn) values(?, ?, ?, ?)";
//		PreparedStatement pstmtInsert = con.prepareStatement(sqlInsert);
//		Iterator it = list.iterator();
//		
//		while(it.hasNext()) {
//			Collections.shuffle(list);
//			pstmtInsert.setInt(1, (int)list.get(1));
//			
////			pstmt.setInt(2, bookNo);
////			pstmt.setString(3, dateOut);
////			pstmt.setString(4, dateIn);
//			
//		}
//	}
	
	
	
	// 도서 대출 가능 여부 확인 
	public boolean checkBook(int bookNo) throws SQLException {
		boolean flag = false;
		
		Connection con = ConnectionManager.getConnection();
		String sql = "select count(bookNo) as nowOut from list where bookNo = ? and datecheck is not null;";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, bookNo);
		
		int affectedCount = 0;
		
		affectedCount = pstmt.executeUpdate();
		
		if(affectedCount > 0) {
			flag = true;
		}
		
		pstmt.close();
		con.close();
		
		return flag;
	}
	
	
	// 도서 대출 
	public boolean insertList(int stdNo, int bookNo) throws SQLException {
		boolean flag = false;
		boolean chekcer = false;
		
		if(this.checkBook(bookNo) == true) {
		Connection con = ConnectionManager.getConnection();
		
		// 장부에 기록하기 
		String sql = "insert into list(stdNo, bookNo, dateOut, dateIn, datecheck) values(?, ?, now(), date_add(now(), interval 7 day), NULL);";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, stdNo);
		pstmt.setInt(2, bookNo);
		
		int affectedCount = 0;
		
		affectedCount = pstmt.executeUpdate();
		
		if(affectedCount > 0) {
			flag = true;
		}
		
		pstmt.close();
		con.close();
		
		return flag;
		} else {
			System.out.println("해당 도서는 현재 대출 불가능합니다");
		}
		return flag;
	}
	
	// 도서 반납 
	public boolean giveBack(int bookNo) throws SQLException {
		boolean flag = false;
		
		Connection con = ConnectionManager.getConnection();
		String sql = "update list set datecheck = now() where bookNo = "+bookNo+";";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		int affectedCount = 0;
		
		affectedCount = pstmt.executeUpdate();
		
		if(affectedCount > 0) {
			flag = true;
		}
		
		pstmt.close();
		con.close();
		
		return flag;
	}
	
	
	
	//0) 현재 대출중인 책의 정보, 대출자, 반납일, 연체여부에 대한 정보를 제공
//	public ArrayList getData00() throws SQLException{
//		String sql = "select b.bookNo, b.title, b.author, b.price, b.inDate, l.dateIn, l.datecheck"
//				+ "from book b, list l"
//				+ "where l.dateCheck is null";
//		Connection con = ConnectionManager.getConnection();
//		PreparedStatement stmt = con.prepareStatement(sql);
//		ResultSet rs = stmt.executeQuery();
//		int bookNo = 0;
//		String title = "";
//		String au
//		while(rs.next()) {
//			list.add(rs.getInt(1));
//			list.add(rs.getString(2));
//			list.add(rs.getNString(3));
//			list.add(rs.getInt(4));
//			list.add(rs.getString(5));
//			list.add(rs.getString(6));
//			list.add(rs.getString(7));
//			List.add(list);
//			}
//		System.out.println(List);
//		return List;
//	}
	
	//1) 대출 도서 상위 5위에 대한 정보
	public ArrayList<ListDAO> getData01(){
		String sql = "";
		return null;
	}
	
	//2) 대출자 상위 5위에 대한 정보
	public ArrayList<ListDAO> getData02(){
		String sql = "";
		return null;
	}
	
	//3) 대출기간이 가장 짧은 도서에 대한 정보
	public ArrayList<ListDAO> getData03(){
		String sql = "";
		return null;
	}
	
	//4) 대출반납이 가장 빠른 학생에 대한 정보
	public ArrayList<ListDAO> getData04(){
		String sql = "";
		return null;
	}
	
	//5) 대출을 가장 많이 하는 학과에 대한 정보
	public ArrayList<ListDAO> getData05(){
		String sql = "";
		return null;
	}
	
	//6) 대출반납이 가장 늦은 학과에 대한 정보
	public ArrayList<ListDAO> getData06(){
		String sql = "";
		return null;
	}
	
}
