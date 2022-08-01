package lesson.day0801;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lesson.jdbc.ConnectionManager;
import lesson.jdbc.StudentVO;

public class ResultSetMain {
	
	public static void main(String[] args) {
		ResultSetMain rs = new ResultSetMain();
		try {
			rs.testResultSet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testResultSetMk2() throws SQLException {
		String sql=""
				+ "select * from gisa where loccode=?"
				+ "";
		
		Connection con = ConnectionManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, "b"); //1은 물음표의 순번이다 1부터 시작
		
		ResultSet rs = pstmt.executeQuery();
		// 테이블의 데이터를 원하는 부분만 저장하기 
		// VO를 이용하여 컬렉션으로 저장 
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
		StudentVO vo = null;
		while(rs.next()) {
			// 열의 번호를 의미한다 0번은 header
			vo = new StudentVO();
			vo.setStdNo(rs.getInt(1));
			vo.setEmail(rs.getString(2));
			vo.setKor(rs.getInt(3));
			vo.setEng(rs.getInt(4));
			vo.setMath(rs.getInt(5));
			vo.setSci(rs.getInt(6));
			vo.setHist(rs.getInt(7));
			vo.setTotal(rs.getInt(8));
			vo.setMgrCode(rs.getString(9));
			vo.setAccCode(rs.getString(10));
			vo.setLocCode(rs.getString(11));
//			System.out.print(rs.getInt(1)+",");
//			System.out.print(rs.getString(2)+",");
//			System.out.print(rs.getInt(3)+",");
//			System.out.print(rs.getInt(4)+",");
//			System.out.print(rs.getInt(5)+",");
//			System.out.print(rs.getInt(6)+",");
//			System.out.print(rs.getInt(7)+",");
//			System.out.print(rs.getInt(8)+",");
//			System.out.print(rs.getString(9)+",");
//			System.out.print(rs.getString(10)+",");
//			System.out.print(rs.getString(11));
			System.out.println();
		}
		rs.close();
		pstmt.close();
		con.close();
	}/*end method*/
	
	public void testResultSet() throws SQLException {
		String sql=""
				+ "select * from gisa where loccode=?"
				+ "";
		
		Connection con = ConnectionManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, "b");
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.print(rs.getInt(1)+",");
			System.out.print(rs.getString(2)+",");
			System.out.print(rs.getInt(3)+",");
			System.out.print(rs.getInt(4)+",");
			System.out.print(rs.getInt(5)+",");
			System.out.print(rs.getInt(6)+",");
			System.out.print(rs.getInt(7)+",");
			System.out.print(rs.getInt(8)+",");
			System.out.print(rs.getString(9)+",");
			System.out.print(rs.getString(10)+",");
			System.out.print(rs.getString(11));
			System.out.println();
		}
		rs.close();
		pstmt.close();
		con.close();
	}/*end method*/
}


