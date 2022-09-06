package guest.pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test.do")
public class BookController extends HttpServlet{
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("BookController Init");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter(); //print에 대한(out.print, println) 기능을 가지고 있다
		resp.setContentType("text/html; charset=utf-8");
		String uri 		= req.getRequestURI();
		String[] temp 	= uri.split("/");
		uri = temp[temp.length - 1]; // 컨텍스트 부분이 사라지고, Annotaion 부분만 남게 된다 
		
		String url = req.getRequestURL().toString(); // String buffer는 계속 변화(내용물이 바뀐다), String은 새로운 객체가 생성
		String ctx = req.getContextPath();
		out.print("<h1>hi servlet!</h1>");
		out.print("<h1> uri = "+uri+"</h1>");
		out.print("<h1> url = "+url+"</h1>");
		out.print("<h1> ctx = "+ctx+"</h1>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("BookContoller Destroyed");
	}
}
