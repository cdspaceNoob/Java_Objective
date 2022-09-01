<%@page import="gntp.lesson.vo.MemberVO"%>
<%@page import="gntp.lesson.dao.MemberDAO"%>
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
String id = request.getParameter("id");
MemberVO member = (MemberVO)request.getAttribute("member");
%>
<form method="post" action="/Svlt01/server">
<table>
<tr>
	<td>아이디 </td>
	<td><input type="text" value="<%=member.getId()%>" name="id" readonly="readonly"></td>
</tr>
<tr>
	<td>비밀번호 </td>
	<td><input type="text" value="<%=member.getPwd()%>" name="pwd"></td>
</tr>
<tr>
	<td>이름 </td>
	<td><input type="text" value="<%=member.getName()%>" name="name"></td>
</tr>
<tr>
	<td>이메일 </td>
	<td><input type="text" value="<%=member.getEmail()%>" name="email"></td>
</tr>
<tr>
	<td>등록일 </td>
	<td><input type="text" value="<%=member.getJoinDate()%>" name="joinDate" readonly="readonly"></td>
</tr>
<tr>
<td colspan=5><input type="submit" value="수정"></td>
</tr>
</table>
</form>
</body>
</html>