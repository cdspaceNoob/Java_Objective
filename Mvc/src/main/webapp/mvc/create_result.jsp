<%@page import="mvc.prac.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> 등록에 성공했습니다 </title>
	</head>
	<body>
		<%
			BookVO book = (BookVO)request.getAttribute("book"); 
		%>
		
		<table>
			<tr>
				<td rowspan=3><img src="<%="./images/" + book.getBook_image() %>" alt=""
				width=400 height=550></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><%=book.getBook_title() %>
			</tr>
			<tr>
				<td>작가</td>
				<td><%=book.getBook_author() %></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><%=book.getBook_price() %></td>
			</tr>
		</table>
		
	</body>
</html>