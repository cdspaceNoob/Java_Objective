package day;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BlMajorDAO {
	
	// 대출 장부에서 학과 및 학과별 대출 기록 조회(GroupBy) 
	public ArrayList<String> selectCountMajor() throws SQLException {
		Connection con = ConnectionManager.getConnection();
		
		String sql = "select a.major, count(a.major) as cnt "
				+ "from studenttbl a, loantbl b  "
				+ "where a.std_no = b.std_no  "
				+ "group by a.major "
				+ "order by cnt desc;";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<String> list = new ArrayList<String>();
		while(rs.next()) {
			String record = rs.getString(1) + " " + rs.getInt(2)+"회";
			list.add(record);
		}
		return list;
	}//selectCountMajor()
	
	
	public ArrayList<String> selectReturnMajor() throws SQLException {
		Connection con = ConnectionManager.getConnection();
		
		String sql = "select b.major, avg(datediff(a.return_date, a.loan_date)) avg_time_return "
				+ "from loantbl a inner join studenttbl b "
				+ "on a.std_no = b.std_no "
				+ "group by b.major "
				+ "order by avg_time_return desc;";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<String> list = new ArrayList<String>();
		while(rs.next()) {
			String record = rs.getString(1) + " " + Math.round(rs.getDouble(2)*100)/100.0+"일";
			
			list.add(record);
		}
		return list;
	}//selectReturnMajor()
}
