package fm.pack.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FmController extends HttpServlet{
	
	public void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");	//request 객체에 담겨오는 한글 보정 
		resp.setContentType("text/html; charset=utf-8"); //response 객체에 들어가는 한글 보정 
		String url = req.getRequestURL().toString();
		String context = req.getContextPath();
		int len = context.length();
		String uri = req.getRequestURI();
		String[] temp = uri.split("/");
		String command = temp[temp.length-1];
//		String uri2 = uri.substring(len+1);
		
		PrintWriter out = resp.getWriter();
		out.print("<h1>hi servlet!</h1>");
		out.print("<h1>uri ="+uri+"</h1>");
//		out.print("<h1>uri2 ="+uri2+"</h1>");
		out.print("<h1>url ="+url+"</h1>");
		out.print("<h1>context path ="+context+"</h1>");
		out.print("<h1>command ="+command+"</h1>");
		
		if(command.equals("list.do")) {
			out.print("<h1>command ="+command+"</h1>");
			out.print("<h1>list.do로 접속한 결과입니다</h1>");
		}
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("서블릿 init");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doHandler(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doHandler(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("서블릿 destroyed");
	}
}
