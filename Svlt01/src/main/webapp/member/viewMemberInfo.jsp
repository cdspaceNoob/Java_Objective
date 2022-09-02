<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
String mode = request.getParameter("mode");
MemberVO member = (MemberVO)request.getAttribute("member");

Date date = member.getJoinDate();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
String time = sdf.format(date); 

/* Date date = new Date();
SimpleDateFormat form = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
String now = form(date); */
%>

<% if(mode.equals("create")){ %>
<form method="post" action="../server?mode=create">
	<table>
	<tr>
		<td>아이디 </td>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td>비밀번호 </td>
		<td><input type="text" name="pwd"></td>
	</tr>
	<tr>
		<td>이름 </td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>이메일 </td>
		<td><input type="text" name="email"></td>
	</tr>
	<!-- <tr>
		<td>등록일 </td>
		<td><input type="text" name="joinDate" readonly="readonly"></td>
	</tr> -->
	<tr>
		<td colspan=5><input type="submit" value="생성"></td>
	</tr>
	</table>
</form>
<% } else {%>
<form method="post" action="/Svlt01/server?mode=list">
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
			<td><input type="text" value="<%=time%>" name="joinDate" readonly="readonly"></td>
		</tr>
		<tr>
			<td colspan=5><input type="submit" value="수정"></td>
		</tr>
	</table>
</form>
<% } %>
</body>
</html>