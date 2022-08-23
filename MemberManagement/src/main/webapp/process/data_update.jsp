<%@page import="management.member.VO.MemberVO"%>
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
String id	 = request.getParameter("id");
String pwd	 = request.getParameter("pwd");
String name  = request.getParameter("name");
String email = request.getParameter("email");

MemberDAO dao = new MemberDAO();
dao.updateData(pwd, name, email, id); 

response.sendRedirect("../service/list.jsp");
%>
</body>
</html>