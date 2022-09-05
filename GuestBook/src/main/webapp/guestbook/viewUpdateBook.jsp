<%@page import="guest.pack.vo.GuestbookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>View Update Book</title>
	</head>
	<body>
	<% 
	GuestbookVO book = (GuestbookVO)request.getAttribute("book");
	System.out.println("book은"+book.getContent());
	%>
		<h1>View Update Book</h1>
		<form action="./BookServlet?command=update" method="post">
			<table>
				<tr>
					<td>글번호</td>
					<td><input type="text" value="<%= book.getSeq()%>" name="seq" readonly="readonly"></td>
				</tr>
				<tr>
					<td>글쓴이</td>
					<td><input type="text" value="<%= book.getUser_id()%>" name="userId" readonly="readonly"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" value="<%= book.getTitle()%>" name="title"></td>
				</tr>
					<tr>
					<td>내용</td>
					<td><input type="text" value="<%= book.getContent()%>" name="content"></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td><%= book.getDateTime()%></td>
				</tr>
				<tr>
					<td>조회수</td>
					<td><%= book.getRead_count()%></td>
				</tr>
			</table>
			<input type="submit" value="수정하기">
		</form>
	</body>
</html>