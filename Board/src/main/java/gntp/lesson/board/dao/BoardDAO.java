package gntp.lesson.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gntp.lesson.board.utils.ConnectionManager;

public class BoardDAO {
	
	// create
	public boolean write(String title, String content, String current_seq, String next_seq) throws SQLException {
		boolean flag = false;
		int affectedCount;
		
		String sql = "insert into board(title, content, current_seq, next_seq, write_date, writer, user_id) "
				+ "values(?, ?, ?, ?, now(), '작성자', '아이디')";
		
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, current_seq);
		pstmt.setString(4, next_seq);
		
		affectedCount = pstmt.executeUpdate();
		if(affectedCount > 0) {
			flag = true;
		}
		ConnectionManager.closeConnection(null, pstmt, con);
		return flag;
	}//create: write()
	
	public boolean read() throws SQLException {
		boolean flag = false;
		int affectedCount;
		
		String sql = "select * from board";
		
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);

		affectedCount = pstmt.executeUpdate();
		if(affectedCount > 0) {
			flag = true;
		}
		ConnectionManager.closeConnection(null, pstmt, con);
		return flag;
	}//read: read()
}
