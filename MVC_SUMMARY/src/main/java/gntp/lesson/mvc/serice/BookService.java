package gntp.lesson.mvc.serice;

import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import gntp.lesson.mvc.dao.BookDAO;
import gntp.lesson.mvc.vo.BookVO;

public class BookService {
	
	public BookVO registBook(ServletRequestContext req) {
		BookVO book = null;
		BookDAO dao = new BookDAO();
		
		
		boolean flag = dao.insertBook(book);
		if(flag) {
			
		}
		return book;
	}//registBook()
}
