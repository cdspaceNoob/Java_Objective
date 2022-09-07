<%@page import="guest.pack.util.DateTimeService"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>방명록 작성</title>
	</head>
	<body>
		<form action="./BookServlet?command=create" method="post">
			<table>
			<tr>
				<td>제목 : </td>
				<td><input type="text" name="title"><br></td>
			</tr>
			<tr>
				<td>내용 : </td>
				<td><input type="text" name="content"><br></td>
			</tr>
			<tr>
				<td>조회수 : </td>
				<td><input type="text" name="readCount" value="0" readonly="readonly"><br></td>
			</tr>
			<tr>
				<td>작성일 : </td>
				<td><input type="text" name="date" value="<%=DateTimeService.getNow() %>" readonly="readonly"><br></td>
			</tr>
			<tr>
				<td>글쓴이 : </td>
				<td><input type="text" name="userId"><br></td>
			</tr>
			<tr>
				<td><input type="submit" value="글쓰기"></td>
			</tr>
			
			</table>
		</form>	
	</body>
</html>