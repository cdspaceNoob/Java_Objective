package fm.pack.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FmController extends HttpServlet{
	
	public void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");					//request 객체에 담겨오는 한글 보정 
		resp.setContentType("text/html; charset=utf-8"); 	//response 객체에 들어가는 한글 보정 
//		String url = req.getRequestURL().toString();		// url 확인
//		String context = req.getContextPath(); 				// context 경로 확인
		String uri = req.getRequestURI();					// uri 확인
		String[] temp = uri.split("/");						// uri를 분리 
		String command = temp[temp.length-1]; 				// uri의 마지막 요소 확인
		String url = "board/list.jsp";
		
//		PrintWriter out = resp.getWriter();
//		out.print("<h1>hi servlet!</h1>");
//		out.print("<h1>uri ="+uri+"</h1>");
//		out.print("<h1>url ="+url+"</h1>");
//		out.print("<h1>context path ="+context+"</h1>");
//		out.print("<h1>command ="+command+"</h1>");
		
//		}else if(command.equals("create.do")) {
//		if(command.equals("read.do")) {
//			out.print("<h1>read.do로 접속한 결과입니다</h1>");
//			out.print("<h1>command= "+command+"</h1>");
//			out.print("<h1>create.do로 접속한 결과입니다</h1>");
//			out.print("<h1>command= "+command+"</h1>");
//		}else if(command.equals("update.do")) {
//			out.print("<h1>update.do로 접속한 결과입니다</h1>");
//			out.print("<h1>command= "+command+"</h1>");
//		}else if(command.equals("delete.do")) {
//			out.print("<h1>delete.do로 접속한 결과입니다</h1>");
//			out.print("<h1>command= "+command+"</h1>");
//		}
		
		if(command.equals("list.do")) {
			resp.sendRedirect(url);
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
