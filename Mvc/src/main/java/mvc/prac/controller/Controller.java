package mvc.prac.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import mvc.prac.service.BookService;
import mvc.prac.vo.BookVO;

@WebServlet("*.do")
public class Controller extends HttpServlet{
	
	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		String uri 		= req.getRequestURI();
		String[] temp	= uri.split("/");
		String command 	= temp[temp.length-1];
		
		String url		= "./mvc/read.jsp";
		BookService bs  = new BookService();
		
		if(command.equals("create.do")) {
			System.out.println("servlet " + command + " 실행");
			 
			/* 
			 * 파일 업로드를 포함하는 request일 때, ServletRequestContext를 사용한다 
			 * 서비스 호출 
			 */
			ServletRequestContext src = new ServletRequestContext(req);
			
			
			BookVO book;
			try {
				book = bs.insertBook(src);
				if(book != null) {
					req.setAttribute("book", book);
					
					/* BookVO 생성 상태 체크를 위한 print */
//					System.out.println(book.getBook_image());
//					System.out.println(book.getBook_author());
//					System.out.println(book.getBook_title());
					
				} else {
					System.out.println("book null!");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			url = "./mvc/create_result.jsp";
		} else if(command.equals("download.do")) {
			System.out.println("servlet " + command + " 실행");
			
			String fileName = req.getParameter("fileName");
			bs.download(fileName, resp);
			
		} else if(command.equals("list.do")) {
			System.out.println("servlet " + command + " 실행");
			
			bs = new BookService();
			ArrayList<BookVO> list  = bs.selectAll();
			req.setAttribute("list", list);
			url = "./read.jsp";
		}
		if(!command.equals("download.do")) {
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, resp);	
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			this.doHandle(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			this.doHandle(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
