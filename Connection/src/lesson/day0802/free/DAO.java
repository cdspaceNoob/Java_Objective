package lesson.day0802.free;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
	
	
	public ArrayList<VO> getData03(int score) throws SQLException{
		String sql = "select * from gisa where eng+math >= ?";
		ArrayList<VO> list = new ArrayList<VO>();
		
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, score);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			VO vo = new VO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)
					, rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11));
			list.add(vo);
		}
		ConnectionManager.closeConnection(rs, pstmt, con);
		
		return list;
	}
	
	
	
	
	
	public ArrayList<VO> getData01(String code) throws SQLException {
		String sql = "select * from gisa where loccode = ?";
		ArrayList<VO> list = new ArrayList<VO>();
		
		// 연결 
		Connection con = ConnectionManager.getConnection();
		
		// 통로 
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, code);
		
		// 쿼리 전송 및 반환 
		ResultSet rs = pstmt.executeQuery();
		
		// 결과셋 정제 
		VO vo = null;
		while(rs.next()) {
			vo = new VO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4) 
						,rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11));
			list.add(vo);
		}
		ConnectionManager.closeConnection(rs, pstmt, con);
		
		return list;
	}/* getData01 */
	
	
	
	
}
