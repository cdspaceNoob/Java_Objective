<%@page import="fm.pack.vo.FmVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>List</title>
	</head>
	<body>
	<%
	ArrayList<FmVO> list = (ArrayList<FmVO>)request.getAttribute("list");
	%>
	<h1>Board list</h1>
		<table>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>등록일</th>
			</tr>
			<%for(FmVO vo : list){ %>
			<tr>
				<td><%=vo.getSeq() %></td>
				<td><%=vo.getTitle() %></td>
				<td><%=vo.getWriter() %></td>
				<td><%=vo.getWrite_date() %></td>
			</tr>
			<% } %>
		</table>
	</body>
</html>