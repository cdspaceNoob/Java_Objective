<%@page import="lib.service.dao.ListDAO"%>
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
String title = request.getParameter("title");
String stdNo = request.getParameter("stdNo");

out.print("책의 이름은 "+title+"<br>");
out.print("로그인된 계정의 학번은 "+stdNo);

// DAO를 불러와서 실행하고
ListDAO ldao = new ListDAO();
ldao.transactionBorrow(title, stdNo);
%>
<!-- 다시 리스트로 리턴한다 -->
<jsp:forward page="../service/searchBook.jsp?stdNo=<%=stdNo %>"></jsp:forward> 
</body>
</html>