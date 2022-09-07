package gntp.lesson.board.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gntp.lesson.board.utils.ConnectionManager;

@WebServlet("/test")
public class BoardController extends HttpServlet{
	
	public void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("BoardController Init");
	}//init();
	
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
		super.destroy();
		System.out.println("BoardController destroyed");
	}//destroy();
}
