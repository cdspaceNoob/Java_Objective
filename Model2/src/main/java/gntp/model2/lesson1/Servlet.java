package gntp.model2.lesson1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("알아서 실행되는 init()");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("브라우저 자체가 get요청이니까 doGet() 실행");
		// 클라이언트한테 어떤 메세지를 보내고 싶다
		// 클라이언트 화면에 무언가를 표시해주고 싶다
		// jsp처럼 out.print()를 사용할 수는 없다 
		// 브라우저로 통하는 스트림을 생성해야 한다
		// HttpServletResponse resp는 클라이언트(브라우저)에 대한 정보를 가지고 있다
		// jsp는 스크립트상에서 굴렸기 때문에 html 파일의 상단에 여러가지를 명시했다(by html)
		// 하지만 java 클래스 파일인 서블릿에서는 따로 정의해둬야 한다 
		resp.setContentType("text/html; charset=utf-8");
		// jsp에서는 out이 주어졌다(out.print();)
		// 그러나 서블릿에서는 out을 PrintWiter를 사용하여 만들어줘야 한다 
		PrintWriter out =  resp.getWriter();
		out.print("<h1>제목 태그를 직접 out.print()로 출력하는 모습입니다</h1>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("이건 안 나와야지");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("컴파일 시 알아서 실행되는 Destroy()");
	}
}
