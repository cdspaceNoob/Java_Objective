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
			response.sendRedirect("../link/loginOK.html");	
		}else{
			response.sendRedirect("../link/loginFailed.html");
		}
		%>
	</body>
</html>