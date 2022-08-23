package lib.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lib.service.util.ConnectionManager;
import lib.service.vo.BookVO;

public class BookDAO {
	
	public ArrayList<BookVO> searchBook(String title) throws SQLException {
		
		String sql = "select * from book where title like ?";
		
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		String rTitle = "%" + title + "%";
		
		System.out.println(rTitle);
		
		pstmt.setString(1, rTitle);
		
//		pstmt.setString(1, title);
//		System.out.println(sql);
		
		BookVO vo = null;
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			vo = new BookVO(rs.getInt("bookno"), rs.getString("title"), rs.getString("author")
					, rs.getInt("price"), rs.getString("indate"));
			list.add(vo);
		}
		return list;
	}//searchBook
}
