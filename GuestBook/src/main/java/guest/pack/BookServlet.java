package guest.pack;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import guest.pack.dao.GuestbookDAO;
import guest.pack.vo.GuestbookVO;

public class BookServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		GuestbookDAO dao = new GuestbookDAO();
		String command = req.getParameter("command");
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
				if(flag=true) {
					System.out.println("insert Success");
				}else {
					System.out.println("insert Fail! check DAO");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			url = "./BookServlet?command=list";
		} else if(command.equals("list")) {
			ArrayList<GuestbookVO> list;
			try {
				list = dao.selectAll();
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
		}else if(command.equals("viewWriteBook")) {
			url = "./guestbook/writebook.jsp";
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
}
