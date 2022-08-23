<%@page import="java.util.ArrayList"%>
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
	String stdNo	= request.getParameter("stdNo");

	BookDAO dao = new BookDAO();
	
	ArrayList<BookVO> list = dao.searchBook(title);
	
/* 	int rsNo 		= vo.getBookNo();
	String rsTitle 	= vo.getTitle();
	String rsAutor 	= vo.getAuthor();
	int rsPrice 	= vo.getPrice();
	String rsDate 	= vo.getDate(); */
	
	request.setAttribute("list", list);
%>
<jsp:forward page="../service/searchBook.jsp?stdNo=<%=stdNo %>"></jsp:forward>
</body>
</html>