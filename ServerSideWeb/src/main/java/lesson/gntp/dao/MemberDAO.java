package lesson.gntp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lesson.gntp.util.ConnectionManager;
import lesson.gntp.vo.LoginVO;

public class MemberDAO {
	
	public boolean selectMember(String id, String pw) throws SQLException {
		LoginVO vo = null;
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		String sql = "select stdno, total, email from gisa where stdno=? and total=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		pstmt.setInt(2, Integer.parseInt(pw));
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			vo = new LoginVO(rs.getString(1), rs.getString(2), rs.getString(3));
		}
		rs.close();
		pstmt.close();
		con.close();
		return flag;
	}//selectMember
	
	public LoginVO selectMemberInfo(String id, String pw) throws SQLException {
		LoginVO vo = null;
		Connection con = ConnectionManager.getConnection();
		String sql = "select stdno, total, email from gisa where stdno=? and total=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		pstmt.setInt(2, Integer.parseInt(pw));
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			vo = new LoginVO(rs.getString(1), rs.getString(2), rs.getString(3));
		}
		rs.close();
		pstmt.close();
		con.close();
		return vo;
	}//selectMemeberInfo
	
	public ArrayList<LoginVO> selectGroupA() throws SQLException {
		LoginVO vo = null;
		Connection con = ConnectionManager.getConnection();
		String sql = "select * from gisa where mgrcode='a' and loccode='a'";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<LoginVO> list = new ArrayList<LoginVO>();
		if(rs.next()) {
			vo = new LoginVO(rs.getString(1), rs.getString(2), rs.getString(3));
			list.add(vo);
		}
		rs.close();
		pstmt.close();
		con.close();
		return list;
	}
}
