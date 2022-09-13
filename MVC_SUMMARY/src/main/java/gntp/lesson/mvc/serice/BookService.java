package gntp.lesson.mvc.serice;

import gntp.lesson.mvc.dao.BookDAO;
import gntp.lesson.mvc.vo.BookVO;

public class BookService {
	
	public BookVO registBook(BookVO book) {
		BookVO vo = null;
		BookDAO dao = new BookDAO();
		boolean flag = dao.insertBook();
		if(!=null) {
			vo = book;
		}
		return vo;
	}//registBook()
}
