package gntp.lesson.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri 		= req.getRequestURI();
		String[] temp 	= uri.split("/");
		String command	= temp[temp.length-1];
		
		String url 		= "./summary/input.jsp"; 
		
		if(command.equals("viewInput.do")) {
			
		}else if(command.equals("")) {
			
		}
		
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
