package mvc.prac.controller;

import java.io.IOException;

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
	
	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri 		= req.getRequestURI();
		String[] temp	= uri.split("/");
		String command 	= temp[temp.length-1];
		
		String url		= "./mvc/read.jsp";
		
		if(command.equals("create.do")) {
			System.out.println(command+" 페이지입니다.");
			 
			/* 
			 * 파일 업로드를 포함하는 request일 때, ServletRequestContext를 사용한다 
			 * 서비스 호출 
			 */
			ServletRequestContext src = new ServletRequestContext(req);
			
			BookService bs = new BookService();
			BookVO book;
			
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doHandle(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doHandle(req, resp);
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
