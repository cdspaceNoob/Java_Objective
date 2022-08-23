package lib.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lib.service.util.ConnectionManager;
import lib.service.vo.UserVO;

public class UserDAO {
	
	public boolean validateUser(int stdNo, int age) throws SQLException {
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		
		String sql = "select * from student where stdNo=? and age=?;";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, stdNo);
		pstmt.setInt(2, age);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			flag=true;
		}
		pstmt.close();
		con.close();
		return flag;
	}//validateUser();
	
	public UserVO detailUser(String stdNo) throws SQLException {
		Connection con = ConnectionManager.getConnection();
		
		int stdNoInt = Integer.valueOf(stdNo); 
		String sql = "select * from student where stdNo=?;";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, stdNoInt);
		
		ResultSet rs = pstmt.executeQuery();
		UserVO vo = null;
		while(rs.next()) {
			vo = new UserVO(rs.getInt("stdNo"), rs.getString("stdName"), rs.getString("major"), rs.getInt("age"));
		}
		return vo;
	}//detailUser();
	
	public boolean updateUser(String major, int age, int stdNo) throws SQLException {
		Connection con = ConnectionManager.getConnection();
		
		boolean flag = false;
//		int stdNoInt = Integer.valueOf(stdNo);
//		int ageInt = Integer.valueOf(age); 
		
		String sql="update student set major=?, age=? where stdNo=?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, major);
		pstmt.setInt(2, age);
		pstmt.setInt(3, stdNo);
		
		int affectedRow = pstmt.executeUpdate();
		if(affectedRow > 0) {
			flag = true;
		}
		return flag;
	}//updateUser();
}
