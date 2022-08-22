<%@page import="management.member.DAO.MemberDAO"%>
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
		String id 		= request.getParameter("id");
		String pwd 		= request.getParameter("pwd");
		String name 	= request.getParameter("name");
		String email 	= request.getParameter("email");
		
		//dao 호출
		MemberDAO dao = new MemberDAO();
		int affectedRow = dao.registData(id, pwd, name, email);
		
		out.print(affectedRow);
		
		if(affectedRow>0){
			response.sendRedirect("../service/list.jsp");
		} %>
		
		
		</body>
</html>