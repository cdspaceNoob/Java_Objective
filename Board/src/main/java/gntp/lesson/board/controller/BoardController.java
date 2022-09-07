package gntp.lesson.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gntp.lesson.board.dao.BoardDAO;
import gntp.lesson.board.utils.ConnectionManager;

@WebServlet("/test")
public class BoardController extends HttpServlet{
	
	public void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String command = req.getParameter("command");
		BoardDAO dao = new BoardDAO();
		
//		PrintWriter out = resp.getWriter();
//		String uri = req.getRequestURI();
//		String[] temp = uri.split("/");
//		String command = temp[temp.length-1];
//		String url = "./Board/listBoard.jsp";
		
		if(command==null) {
			
		}
		else if(command.equals("create")) {
			boolean flag = false;
			
			String title 		= req.getParameter("title");
			String content 		= req.getParameter("content");
			String current_seq 	= req.getParameter("current_seq");
			String next_seq 	= req.getParameter("next_seq");
			
			try {
				flag = dao.write(title, content, current_seq, next_seq);
				if(flag==true) {
					System.out.println("insert OK");
				}else {
					System.out.println("insert fail! check DAO");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}/*end if create*/
		RequestDispatcher rd = req.getRequestDispatcher("/board/listBoard.jsp");
		rd.forward(req, resp);
	}/* END OF doHandler */
	
	
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
