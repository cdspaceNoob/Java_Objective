<%@page import="gntp.model2.lesson1.util.ConnectionManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="gntp.lesson.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel=>
</head>
<body>
<h1>Member List</h1>
<%
Connection con = ConnectionManager.getConnection();
if(con==null){
	System.out.println("연결안됨");
}

ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");


if(list==null){
	System.out.println("리스트 없음 ");
}


%>
<table>
	<tr>
		<td>아이디 </td>
		<td>비밀번호 </td>
		<td>이름 </td>
		<td>이메일 </td>
		<td>등록일 </td>
	</tr>
	<% for(MemberVO member : list){ %>
	<tr>
		<td><a href="../logic/process2.jsp?id=<%=member.getId() %>"><%=member.getId() %></a></td>
		<td><%=member.getPwd() %></td>
		<td><%=member.getName() %></td>
		<td><%=member.getEmail() %></td>
		<td><%=member.getJoinDate() %></td>
	</tr>
	<% }%> 
</table>
</body>
</html>