package lib.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lib.service.util.ConnectionManager;

public class UserDAO {
	
	public boolean validateUser(int stdNo, int age) throws SQLException {
		boolean flag = false;
		
		String sql = "select * from student where stdNo=? and age=?";
		
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, stdNo);
		pstmt.setInt(2, age);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			flag=true;
		}
		return flag;
	}//validateUser
}
