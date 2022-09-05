<%@page import="guest.pack.dao.GuestbookDAO"%>
<%@page import="guest.pack.vo.GuestbookVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>방명록 목록</title>
	</head>
	<body>
	<%
	ArrayList<GuestbookVO> list = (ArrayList<GuestbookVO>)session.getAttribute("list");
	
/* 	GuestbookDAO dao = new GuestbookDAO();
	ArrayList<GuestbookVO> list = dao.selectAll(); */
	GuestbookVO vo = new GuestbookVO();
	%>
		<h1>글 목록</h1>
		<a href="./guestbook/writebook.jsp">작성하기</a>
		<table>
			<tr>
				<th>글번호</th>
				<th>글쓴이</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<% for(int i=0; i<list.size(); i++){
				vo = list.get(i);
			%>
			<tr>
				<td><%=vo.getSeq() %></td>
				<td><%=vo.getUser_id() %></td>
				<td><a href="./BookServlet?command=viewUpdateBook&seq=<%= vo.getSeq() %>"><%=vo.getTitle() %></a></td>
				<td><%=vo.getContent() %></td>
				<td><%=vo.getDateTime() %></td>
				<td><%=vo.getRead_count() %></td>
			</tr>
			<% } %>
		</table>
	</body>
</html>