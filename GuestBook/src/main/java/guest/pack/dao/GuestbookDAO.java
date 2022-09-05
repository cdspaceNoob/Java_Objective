package guest.pack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import guest.pack.util.ConnectionManagerV2;
import guest.pack.vo.GuestbookVO;

public class GuestbookDAO {

	// Create
	public boolean insertOne(GuestbookVO book) throws SQLException {
		boolean flag = false;
		Connection con = ConnectionManagerV2.getConnection();
		if(con!=null) {
			System.out.println("DAO Connection Check: connected");
		}else {
			System.out.println("DAO Connection Check: fail!");
		}
		String sql = "insert into guestbook(user_id, title, content) "
				+ "values(?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getUser_id());
		pstmt.setString(2, book.getTitle());
		pstmt.setString(3, book.getContent());
		
		int affectedRow = pstmt.executeUpdate();
		
		if(affectedRow > 0) {
			flag = true;
		}
		ConnectionManagerV2.closeConnection(null, pstmt, con);
		return flag;
	}//insertOne()
	
	// Read(all)
	public ArrayList<GuestbookVO> selectAll() throws SQLException {
		String sql ="select * from guestbook";
		Connection con = ConnectionManagerV2.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<GuestbookVO> list = new ArrayList<GuestbookVO>();
		while(rs.next()) {
			GuestbookVO vo = new GuestbookVO(rs.getInt("seq"), rs.getString("user_id"),
					rs.getString("title"),rs.getString("content"),
					rs.getString("reg_date"),rs.getInt("read_count") );
			list.add(vo);
		}
		ConnectionManagerV2.closeConnection(null, pstmt, con);
		return list;
	}//selectAll()

	// Read(one)
	public GuestbookVO selectOne(int seq) throws SQLException {
		String sql = "select * from guestbook where seq = ?";
		Connection con = ConnectionManagerV2.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, seq);
		ResultSet rs = pstmt.executeQuery();
		GuestbookVO vo = null; 
		while(rs.next()) {
			 vo = new GuestbookVO(rs.getInt("seq"), rs.getString("user_id"),
					rs.getString("title"), rs.getString("content"), 
					rs.getString("reg_date"), rs.getInt("read_count"));
		}
		ConnectionManagerV2.closeConnection(rs, pstmt, con);
		return vo;
	}
	
	// Update(one)
	public boolean updateOne(int seq, String title, String content) throws SQLException {
		boolean flag = false;
		String sql = "update guestbook set title = ?, content = ? where seq = ?";
		Connection con = ConnectionManagerV2.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setInt(3, seq);
		int affectedRow = pstmt.executeUpdate();
		if(affectedRow > 0) {
			flag = true;
		}
		ConnectionManagerV2.closeConnection(null, pstmt, con);
		return flag;
	}




}//END OF THIS FILE
