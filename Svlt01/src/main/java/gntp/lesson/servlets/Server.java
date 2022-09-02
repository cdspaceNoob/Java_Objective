package gntp.lesson.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gntp.lesson.dao.MemberDAO;
import gntp.lesson.vo.MemberVO;

public class Server extends HttpServlet{
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("서블릿 파일 진입");
	}
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=utf-8");
		
		String url = "./member/list.jsp";
		MemberDAO mdao = new MemberDAO();
		String command = req.getParameter("command");

		// 조건에 따라 전체 리스트 조회 페이지 리턴, 기본 페이지는 list
		if(command==null || command.equals("list")) {
			try {
				System.out.println("전체 리스트 조회 요청을 처리합니다");
				ArrayList<MemberVO> list = mdao.selectAll();
				req.setAttribute("list", list);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// 조건에 따라 개별 정보 조회 페이지 리턴 
		} else if(command.equals("read")) {
			System.out.println("개별 정보 조회 요청을 처리합니다(수정form)");
			String id = req.getParameter("id");
			MemberVO member = null;
			try {
				member = mdao.selectOne(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("member", member);
			url = "./member/viewMemberInfo.jsp?mode=''";
		} else if(command.equals("create")) {
			System.out.println("새로운 정보 입력 페이지로 이동합니다");
			resp.sendRedirect("./member/viewMemberInfo.jsp?mode=create");
			return;
		} else if(command.equals("del")) {
			System.out.println("정보 삭제 기능을 실행합니다");
			String id = req.getParameter("id");
			try {
				mdao.delOne(id);
				ArrayList<MemberVO> list = mdao.selectAll();
				System.out.println("삭제 완료되었습니다");
				req.setAttribute("list", list);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}//doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mode = req.getParameter("mode");
		MemberDAO mdao = new MemberDAO();
		if(mode.equals("list")) {
			System.out.println("Post 요청을 처리합니다.(수정 후 list로)");
			String id 	 = req.getParameter("id");
			String pwd 	 = req.getParameter("pwd");
			String name  = req.getParameter("name");
			String email = req.getParameter("email");
			MemberVO member = new MemberVO(id, pwd, name, email, null);
//			RequestDispatcher rd = req.getRequestDispatcher("server?command=list");
			try {
				boolean flag = mdao.updateOne(member);
				if(flag){
//					rd.forward(req, resp);
					resp.sendRedirect("server?command=list");
					System.out.println("처리되었습니다");
					return;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} else if(mode.equals("create")) {
			System.out.println("Post 요청을 처리합니다.(새로운 데이터 생성)");
			String id 	 = req.getParameter("id");
			String pwd 	 = req.getParameter("pwd");
			String name  = req.getParameter("name");
			String email = req.getParameter("email");
			try {
				boolean flag = mdao.createOne(id, pwd, name, email);
				if(flag==true) {
					resp.sendRedirect("./server?command=list");
				} else {
					System.out.println("servlet Post 작업 실패");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}//doPost
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("서블릿 파일 종료");
	}
}
