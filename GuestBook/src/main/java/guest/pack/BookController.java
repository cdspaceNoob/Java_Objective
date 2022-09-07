package guest.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import guest.pack.dao.GuestbookDAO;
import guest.pack.vo.GuestbookVO;

@WebServlet("/test.do")
public class BookController extends HttpServlet{
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("BookController Init");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter(); //print에 대한(out.print, println) 기능을 가지고 있다
		String uri 		= req.getRequestURI();
		String[] temp 	= uri.split("/");
		String command = temp[temp.length - 1]; // 컨텍스트 부분이 사라지고, Annotaion 부분만 남게 된다 
		
//		String url = req.getRequestURL().toString(); // String buffer는 계속 변화(내용물이 바뀐다), String은 새로운 객체가 생성
		
//		String ctx = req.getContextPath();
//		int len 	= ctx.length();
//		String uri2	= uri.substring(len+1);
		
//		out.print("<h1>hi servlet!</h1>");
//		out.print("<h1> uri = "+uri+"</h1>");
//		out.print("<h1> uri = "+uri2+"</h1>");
//		out.print("<h1> url = "+url+"</h1>");
//		out.print("<h1> ctx = "+ctx+"</h1>");
		
		
		GuestbookDAO dao = new GuestbookDAO();
//		String command = req.getParameter("command");
		String url = "./guestbook/listbook.jsp";
		if(command==null) {
			command = "list";
		}
		if(command.equals("create")){
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String userId = req.getParameter("userId");
			
			GuestbookVO vo = new GuestbookVO();
			
			vo.setTitle(title);
			vo.setContent(content);
			vo.setUser_id(userId);
			
			try {
				boolean flag = dao.insertOne(vo);
				if(flag==true) {
					System.out.println("insert Success");
				}else {
					System.out.println("insert Fail! check DAO");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			url = "./BookServlet?command=list";
		} else if(command.equals("list.do")) {
			try {
				ArrayList<GuestbookVO> list = dao.selectAll();
				HttpSession session = req.getSession();
				session.setAttribute("list", list);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("viewUpdateBook")) {
			String seq = req.getParameter("seq");
			int seqVal = Integer.parseInt(seq);
			GuestbookVO book = null; 
			try {
				book = dao.selectOne(seqVal);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("book", book);
			url = "./guestbook/viewUpdateBook.jsp";
		}else if(command.equals("update")) {
			String seq = req.getParameter("seq");
			int seqVal = Integer.parseInt(seq);
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			try {
				dao.updateOne(seqVal, title, content);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			url = "./BookServlet";
			resp.sendRedirect(url);
			return;
		}else if(command.equals("del")) {
			String seq = req.getParameter("seq");
			int seqVal = Integer.parseInt(seq);
			try {
				boolean flag = dao.delOne(seqVal);
				if(flag==true) {
					System.out.println("delete OK");
				}else {
					System.out.println("del One FAIL!");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			url = "./BookServlet";
			resp.sendRedirect(url);
			return;
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("BookContoller Destroyed");
	}
}
