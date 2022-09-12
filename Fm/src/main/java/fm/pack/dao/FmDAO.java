package fm.pack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fm.pack.utils.ConnectionManager;
import fm.pack.vo.FmVO;

public class FmDAO {
	
	public ArrayList<FmVO> selectAll() throws SQLException {
		String sql = "select * from board";
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		FmVO vo = null;
		ArrayList<FmVO> list = new ArrayList<FmVO>();
		while(rs.next()) {
			vo = new FmVO();
					vo.setCurrent_seq(rs.getString("seq"));
					vo.setWrite_seq(rs.getInt("write_seq"));
					vo.setCurrent_seq(rs.getString("current_seq"));
					vo.setTitle(rs.getString("title"));
					vo.setContent(rs.getString("content"));
					vo.setRead_count(rs.getInt("read_count"));
					vo.setNext_seq(rs.getString("next_seq"));
					vo.setWrite_date(rs.getString("write_date"));
					vo.setWriter(rs.getString("writer"));
					vo.setUser_id(rs.getString("user_id"));
					list.add(vo);
		}
		return list;
	}//selectAll()
}
