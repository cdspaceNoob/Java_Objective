package lib.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lib.service.util.ConnectionManager;
import lib.service.vo.BookVO;

public class BookDAO {
	
	// 도서 검색(이름으로 검색) 
	public ArrayList<BookVO> searchBook(String title) throws SQLException {
		String sql = "select * from book where title like ?";
		String rTitle = "%" + title + "%"
				;
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, rTitle);		
		
//		System.out.println(rTitle);
//		pstmt.setString(1, title);
//		System.out.println(sql);
		
		BookVO vo = null;
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString("inshelf"));
			vo = new BookVO(rs.getInt("bookno"), rs.getString("title"), rs.getString("author")
					, rs.getInt("price"), rs.getString("indate"), rs.getString("inshelf"));
			list.add(vo);
		}
		return list;
	}//searchBook()
	
	// 도서를 보유 중인지: inshelf값이 Y인지 판단
	public boolean isInShelf(String title) throws SQLException {
		boolean flag = false;
		String rTitle = "%" + title + "%";
		String sql = "update book set inshelf = 'N' where title=?;";
		
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, rTitle);	
		
		return flag; // 보유 중이면 Y이며 Y는 true를 리턴 
	}//inInShelf()
	

	
	// 대출 권 수가 5권 이하인가? (현재 몇 권 빌려갔는지 체크하여 대여 가능 여부 판단)  
	public boolean selectCntBorrow(String stdNo) throws SQLException {
		boolean flag = false;
		int cnt = 0;	// 몇 권 빌렸는지 정확하게 
		String sql = "select count(*) as cnt from list l, book b "
				+ "where l.stdno=? and b.inshelf='N';";
		
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(stdNo));	
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			cnt = rs.getInt("cnt");
		}
		
		if(cnt <= 4) {
			flag = true;
		}
		System.out.println(cnt+"권 대출 중입니다");
		return flag;
	}//selectCntBorrow()
	
}//end of DAO
