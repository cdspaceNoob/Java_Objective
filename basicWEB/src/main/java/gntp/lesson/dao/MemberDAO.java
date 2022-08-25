package gntp.lesson.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gntp.lesson.util.ConnectionManager;
import gntp.lesson.vo.MemberVO;

public class MemberDAO {
	//멤버정보 수정 
	public boolean updateOne(MemberVO member) throws SQLException {
		boolean flag = false;
		String sql = "update member set pwd=?, name=?, email=? where id=?;";
		
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(4, member.getId());
		pstmt.setString(1, member.getPwd());
		pstmt.setString(2, member.getName());
		pstmt.setString(3, member.getEmail());
		
		int affectedRow = pstmt.executeUpdate();
		if(affectedRow > 0) {
			flag = true;
		}
		ConnectionManager.closeConnection(null, pstmt, con);
		return flag;
	}//updateOne
	
	
	//전체 조회 
	public ArrayList<MemberVO> selectAll() throws SQLException{
	ArrayList<MemberVO> list = new ArrayList<MemberVO>();
	String sql = "select * from member;";
	
	Connection con = ConnectionManager.getConnection();
	PreparedStatement pstmt = con.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	
	MemberVO vo = null;
	while(rs.next()) {
		vo = new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5));
		list.add(vo);
	}
	ConnectionManager.closeConnection(rs, pstmt, con);
	return list;
	}//selectAll
	
	//개별 조회 
	public MemberVO selectOne(String id) throws SQLException {
		MemberVO member = null;
		String sql = "select * from member where id=?;";
		
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			member = new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5));
		}
		ConnectionManager.closeConnection(rs, pstmt, con);
		return member;
	}//selectOne
}
