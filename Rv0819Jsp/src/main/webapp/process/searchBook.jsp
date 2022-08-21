<%@page import="lib.service.vo.BookVO"%>
<%@page import="lib.service.dao.BookDAO"%>
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
	String title	= request.getParameter("book_name");

	BookDAO dao = new BookDAO();
	BookVO vo = dao.searchBook(title);
	
/* 	int rsNo 		= vo.getBookNo();
	String rsTitle 	= vo.getTitle();
	String rsAutor 	= vo.getAuthor();
	int rsPrice 	= vo.getPrice();
	String rsDate 	= vo.getDate(); */
	
	request.setAttribute("vo", vo);
%>
<jsp:forward page="../service/searchBook.jsp"></jsp:forward>
</body>
</html>