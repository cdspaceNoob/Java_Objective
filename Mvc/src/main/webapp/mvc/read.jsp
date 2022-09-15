<%@page import="java.net.URLEncoder"%>
<%@page import="mvc.prac.vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> 여기에서 도서 리스트 출력 </title>
	</head>
	<body>
	<%
	ArrayList<BookVO> list = (ArrayList<BookVO>)request.getAttribute("list");
	if(list == null){
		System.out.println("ArrayList<BookVO> is null at page read.jsp");
	}
	%>
		<table border=1>
		<%for(BookVO book : list) {%>
			<tr>
				<td>제목</td>
				<td><%=book.getBook_title() %></td>
			</tr>
			<tr>
				<td>작가</td>
				<td><%=book.getBook_author() %></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><%=book.getBook_price() %></td>
			</tr>
			<tr>
				<td>커버</td>
				<td><img src="<%="../images/" + book.getBook_image() %>" alt=""></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<% if(book.getBook_attachment() != null){ %>
				<td>
					<a href="download.do?fileName=<%=URLEncoder.encode(book.getBook_attachment(), "utf-8") %>"><%=book.getBook_attachment() %></a>
				</td>
				<% } %>
			</tr>
			<% } %>
		</table>
	</body>
</html>