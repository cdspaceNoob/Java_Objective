package gntp.model2.lesson1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gntp.model2.lesson1.dao.MemberDAO;
import gntp.model2.lesson1.util.ConnectionManager;
import gntp.model2.lesson1.vo.MemberVO;

public class List extends HttpServlet{
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("List페이지 init");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = ConnectionManager.getConnection();
		if(con==null) {
			System.out.println("con 연결 안 됨");
		}
		
		System.out.println("List 로직 실행");
		MemberDAO dao = new MemberDAO();
		try {
			ArrayList<MemberVO> list = dao.selectAll();
			if(list==null) {
				System.out.println("MemberDAO 메소드 실행에 문제가 있습니다");
			}
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<table>");
			out.print("<tr>"
					+ "<td>아이디</td>"
					+ "<td>비밀번호</td>"
					+ "<td>이름</td>"
					+ "<td>이메일</td>"
					+ "<td>등록일</td>"
					+ "</tr>");
			for(MemberVO member : list) {
				out.print("<tr>");
				out.print("<td>"+member.getPwd()+"</td>");
				out.print("<td>"+member.getName()+"</td>");
				out.print("<td>"+member.getEmail()+"</td>");
				out.print("<td>"+member.getJoinDate()+"</td>");
				out.print("</tr>");
			}
			out.print("</table>");
			ConnectionManager.closeConnection(null, null, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("List페이지 destroyed");
	}
}
