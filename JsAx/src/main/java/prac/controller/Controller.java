package prac.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet{
	
	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String uri 		= req.getRequestURI();
//		String[] temp 	= uri.split("/");
//		String command	= temp[temp.length-1];
		String command  = req.getParameter("command");
		String url		= "/pages/regist.jsp";
		
		if(command == null) {
			command = "create";
		}
		
		if(command.equals("create")) {
			System.out.println("Servlet command: create");
			
			
		} else if(command.equals("checkId")) {
			System.out.println("Servlet command: checkId");
			String userId = req.getParameter("userId");
			System.out.println("userId: " + userId);
			resp.getWriter().print("checkId run!");
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doHandle(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doHandle(req, resp);
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroyed");
	}

}
