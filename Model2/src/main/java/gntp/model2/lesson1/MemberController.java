package gntp.model2.lesson1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import gntp.model2.dao.MemberDAO;
import gntp.model2.service.MemberService;
import gntp.model2.vo.MemberVO;

// userMethodNameResolver를 <property>로 사용하기 위해서는 반드시 MultiActionController를 상속받아야 한다. 
public class MemberController extends MultiActionController {
	
	// xml 설정에 따른 DI 주입
	private MemberDAO dao;

	// xml 설정에 따른 DI 주입
	public void setDao(MemberDAO memberDAO) {
		this.dao = memberDAO;
	}

	// login 원본
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = "";
		String passwd = "";
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");

		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);
		mav.setViewName("result");
		return mav;
	}
	
//	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String userID = "";
//		String passwd = "";
//		ModelAndView mav = new ModelAndView();
//		request.setCharacterEncoding("utf-8");
//		userID = request.getParameter("userID");
//		passwd = request.getParameter("passwd");
//		String viewName=getViewName(request);
//		
//		mav.addObject("userID", userID);
//		mav.addObject("passwd", passwd);
//		//mav.setViewName("result");
//		mav.setViewName(viewName);
//	    System.out.println("ViewName:"+viewName);
//		return mav;
//	}

	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setCharacterEncoding("utf-8");
	    ModelAndView mav=new ModelAndView();
	    String id=request.getParameter("id");
	    String pwd=request.getParameter("pwd");
	    String name=request.getParameter("name");
	    String email=request.getParameter("email");

	    mav.addObject("id",id);			// addObject는 Request 객체에 데이터를 바인딩한다 
	    mav.addObject("pwd",pwd);
	    mav.addObject("name",name);
	    mav.addObject("email",email);
	    mav.setViewName("memberInfo");
	    return mav;
	}

	
	
	private  String getViewName(HttpServletRequest request) throws Exception {
	      String contextPath = request.getContextPath();
	      String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
	      if(uri == null || uri.trim().equals("")) {
	         uri = request.getRequestURI();
	      }
	      
	      //http://localhost:8090/member/listMember.do�� ��û��
	      int begin = 0;  //
	      if(!((contextPath==null)||("".equals(contextPath)))){
	         begin = contextPath.length();  // ��ü ��û�� �� ���̸� ����
	      }

	      int end;
	      if(uri.indexOf(";")!=-1){
	         end=uri.indexOf(";");  //��û uri�� ';'�� ���� ��� ';'���� ��ġ�� ����
	      }else if(uri.indexOf("?")!=-1){
	         end=uri.indexOf("?");   //��û uri�� '?'�� ���� ��� '?' ���� ��ġ�� ����
	      }else{
	         end=uri.length();
	      }

	      //http://localhost:8090/member/listMember.do�� ��û�� ���� '.do'�� ������ http://localhost:8090/member/listMember�� ���� ��,
	      //�ٽ� http://localhost:8090/member/listMember���� �������� ù��° '/' ��ġ�� ���� ��, �� ���� listMember�� ���Ѵ�.
	      String fileName=uri.substring(begin,end);
	      if(fileName.indexOf(".")!=-1){
	         fileName=fileName.substring(0,fileName.lastIndexOf("."));  //��û���� �������� ���� '.'�� ��ġ�� ������, '.do' �տ������� ���ڿ��� ����
	      }
	      if(fileName.lastIndexOf("/")!=-1){
	         fileName=fileName.substring(fileName.lastIndexOf("/"),fileName.length()); //��û���� �������� ���� '/'�� ��ġ�� ������, '/' ���������� ���ڿ��� ����  
	      }
	      return fileName;
	   }

	public void test(HttpServletRequest req, HttpServletResponse resp) {
		try {
			PrintWriter pw = resp.getWriter();
			pw.print("this is test for PropertiesMethodNameResolver");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//test()
	
	
	public ModelAndView join(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = this.getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		
		return mav;
	}
	
	
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		mav.setViewName("memberForm");
		
		//정답
		String viewName = this.getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		
	    return mav;
	}//memberForm();
	
	public ModelAndView inputForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		mav.setViewName(viewName);
		return mav;
	}//inputForm()
	
	public ModelAndView insertMember(HttpServletRequest request, HttpServletResponse resp) throws Exception {		
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		ModelAndView mav = new ModelAndView();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		dao.insertMember(id, pwd, name, email);
//		list = ms.selectAll();
		
//		mav.addObject("list", list);
//		mav.setViewName("list");
		
//		mav = this.showList(request, resp);
		// setViewName의 파라미터는 jsp파일의 실제 이름이다
		
		mav.setViewName("redirect:./list.do");
		
		return mav;
	}//insertOne()
	
	public void testForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter pw = response.getWriter();
		pw.print("이거 맞니");
	}// for test
	
	public ModelAndView deleteOne(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String id 		 = request.getParameter("id");
		ModelAndView mav = new ModelAndView();
		
		dao.deleteOne(id);
		
//		mav = this.showList(request, response);
		mav.setViewName("redirect:./list.do");
		
		return mav;
	}//delOne()
	
	public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		ArrayList<MemberVO> list = dao.selectAll();
		
		mav.addObject("list", list);
		mav.setViewName("list");
		
		return mav;
	}//showList()
	
	public ModelAndView updateOne(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MemberVO member = null;
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		member = new MemberVO(id, pwd, name, email, null);
		try {
			dao.updateOne(member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		mav = this.showList(request, response);
		mav.setViewName("redirect:./list.do");
		
		return mav;
	}//updateOne()
	
	public ModelAndView viewOne(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		ModelAndView mav = new ModelAndView();
		MemberService ms = new MemberService();
		MemberVO member  = null;
		String id 		 = request.getParameter("id");
		
		member = dao.selectOne(id);
		
		mav.addObject("member", member);
		mav.setViewName("viewMemberInfo");
		
		return mav;
	}//viewOne()
	
	
}
