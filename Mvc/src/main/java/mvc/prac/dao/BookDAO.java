package mvc.prac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import mvc.prac.utils.ConnectionManager;
import mvc.prac.vo.BookVO;

public class BookDAO {
	public boolean insertBook(BookVO vo) throws SQLException {
		boolean flag = false;
		BookVO book  = null;
		
		String 	book_title 		= vo.getBook_title();
		String 	book_author 	= vo.getBook_author();
		int 	book_price 		= vo.getBook_price();
		String 	book_image		= vo.getBook_image();
		String	book_attachment = vo.getBook_attachment();
		
		String sql ="insert into library(book_title, book_author, book_price, book_image, book_attachment)"
					+ " values(?, ?, ?, ? ,?)"
					+ ";";
		
		Connection con = ConnectionManager.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, book_title);
		stmt.setString(2, book_author);
		stmt.setInt(3, book_price);
		stmt.setString(4, book_image);
		stmt.setString(5, book_attachment);
		
		int affectedRow = stmt.executeUpdate();
		
		if(affectedRow>0) {
			flag = true;
		}
		
		return flag;
	}//insertBook()
}
