<%@page import="lesson.gntp.util.LoginCheck"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
/* JSP에서 Java Class를 사용하는 방법에 대해 */
// 데이터 처리 페이지  
// 클라이언트로부터 받은 데이터 처리 
String id = request.getParameter("id");
String pw = request.getParameter("pw");


//유저 커스텀 클래스 호출 및 사용
LoginCheck check = new LoginCheck();
boolean flag = check.isMemeber(id, pw);

//받은 데이터를 Logic에 투입
String url = "fail.jsp";
if(flag==true){
	url = "success.jsp";
}
response.sendRedirect(url);
%>
</body>
</html>