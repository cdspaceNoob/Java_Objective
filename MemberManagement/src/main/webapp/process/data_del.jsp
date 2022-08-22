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
String id = request.getParameter("id");
System.out.println(id);

MemberDAO dao = new MemberDAO();
int affectedRow = dao.delData(id);
if(affectedRow>0){
	response.sendRedirect("../service/list.jsp");
}
%>
</body>
</html>