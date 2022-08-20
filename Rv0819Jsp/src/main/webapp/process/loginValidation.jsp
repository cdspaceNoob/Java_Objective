<%@page import="lib.service.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login Validation</title>
	</head>
	<body>
		<% 
		String stdNo 	= request.getParameter("stdNo");
		String age		= request.getParameter("age");
		boolean flag 	= false;
		
		UserDAO dao = new UserDAO();
		flag = dao.validateUser(Integer.parseInt(stdNo), Integer.parseInt(age));
		
		if(flag==true){
			response.sendRedirect("../link/loginOK.jsp");	
		}else{
		%>
			<!-- <script>alert("정보가 일치하지 않습니다");</script> -->
			<!--  response.sendRedirect("../link/loginFailed.jsp"); -->
		<%
		response.sendRedirect("../link/loginFailed.jsp");
		}
		%>
	</body>
</html>