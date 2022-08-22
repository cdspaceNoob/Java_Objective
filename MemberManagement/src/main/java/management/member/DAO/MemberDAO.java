package management.member.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import management.member.VO.MemberVO;
import management.member.util.ConnectionManager;

public class MemberDAO {
	
	// 등록 
	public int registData(String id, String pwd, String name, String email) throws SQLException {
		Connection con = ConnectionManager.getConnection();
		
		String sql = "insert into t_member(id, pwd, name, email) values(?, ?, ?, ?);";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		pstmt.setString(3, name);
		pstmt.setString(4, email);
		
		int affectedRow = pstmt.executeUpdate();
		if(affectedRow>0) {
			System.out.println("정상 처리되었습니다 / 생성된 데이터의 개수: "+affectedRow+"개");
		}
		pstmt.close();
		con.close();
		return affectedRow;
	}//registData()
	
	// 조회
	public ArrayList<MemberVO> viewData() throws SQLException{
		Connection con = ConnectionManager.getConnection();
		
		String sql = "select * from t_member;";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO vo = null;
		
		while(rs.next()) {
			vo = new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			list.add(vo);
		}
		return list;
	}
	
	//삭제 
	public int delData(String id) throws SQLException {
		Connection con = ConnectionManager.getConnection();
		
		String sql = "delete from t_member where id = ?;";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		
		int affectedRow = pstmt.executeUpdate();
		if(affectedRow>0) {
			System.out.println("정상 처리되었습니다 / 제거된 데이터의 개수: "+affectedRow+"개");
		}
		pstmt.close();
		con.close();
		return affectedRow;
	}
}
