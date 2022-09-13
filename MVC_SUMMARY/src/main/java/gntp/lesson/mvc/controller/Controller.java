package gntp.lesson.mvc.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import gntp.lesson.mvc.serice.BookService;
import gntp.lesson.mvc.utils.ConnectionManager;
import gntp.lesson.mvc.vo.BookVO;

public class Controller extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// load-on-start이므로 자동으로 호출된다
		String uri 		= req.getRequestURI();
		String[] temp 	= uri.split("/");
		String command	= temp[temp.length-1];
		
		String url 		= "./summary/input.jsp"; 
		
		if(command.equals("viewInput.do")) {
			System.out.println(command);
		}else if(command.equals("outPut.do")) {
			// DB에 등록하면서 그거 받아올 거임
			
//			Connection con = ConnectionManager.getConnection();
//			if(con!=null) {
//				System.out.println(command);
//				System.out.println("connected");
//				ConnectionManager.closeConnection(null, null, con);
//			}else {
//				System.out.println("connection fail");
//			}
			ServletRequestContext src = new ServletRequestContext(req);
			
			String bookTitle = req.getParameter("bookTitle");
			String bookAuthor = req.getParameter("bookAuthor");
			int bookPrice = Integer.parseInt(req.getParameter("bookPrice"));
			String bookImage = req.getParameter("bookImage");
			
			BookVO vo = new BookVO(0, bookTitle, bookAuthor, bookPrice, bookImage, null);
			
			BookService service = new BookService();
			BookVO book = service.registBook(src);
			
			if(book != null) {
				req.setAttribute("book", book);
			}
			req.setAttribute("vo", vo);
			url = "./summary/output.jsp";
		}
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}//doPost()
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("servlet init");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("servlet destroyed");
	}
}
