package guest.pack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
//		String md = req.getParameter("md");
//		System.out.println(md);
//		if(md.equals("list")) {
//			RequestDispatcher rd = req.getRequestDispatcher("./guestbook/listbook.jsp");
//			rd.forward(req, resp);
//		}
		req.setCharacterEncoding("utf-8");
		String command = req.getParameter("command");
		if(command==null) {
			command = "list";
		}
		String url = "./guestbook/listbook.jsp";
		
		GuestbookDAO dao = new GuestbookDAO();
		dao.insertOne(null);
		
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
}
