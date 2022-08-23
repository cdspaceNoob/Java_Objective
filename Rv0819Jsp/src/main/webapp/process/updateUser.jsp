<%@page import="lib.service.dao.UserDAO"%>
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
request.setCharacterEncoding("UTF-8");
int stdNo = Integer.valueOf(request.getParameter("stdNo"));
String stdName = request.getParameter("stdName");
String major = request.getParameter("major");
int age = Integer.valueOf(request.getParameter("age"));

UserDAO dao = new UserDAO();
boolean flag = dao.updateUser(major, age, stdNo);
if(flag){
	
	out.print("<script>");
	out.print("alert('갱신되었습니다');");
	out.print("<window.location.replace('../link/loginOK.jsp?stdNo="+stdNo+"');>");
	out.print("</script>"); 
	/* <jsp:forward page="../process/loginValidation.jsp"></jsp:forward> */
	}else{
		out.print("<script>");
		out.print("alert('갱신 실패');");
		out.print("<window.location.replace('../link/loginFailed.jsp');>");
		out.print("</script>"); 
	}
	%>
</body>
</html>