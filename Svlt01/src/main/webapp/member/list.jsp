<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="gntp.lesson.util.ConnectionManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="gntp.lesson.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 리스트</title>
	</head>
		<body>
			<h1>Member List</h1>
			<%
			Connection con = ConnectionManager.getConnection();
			if(con==null){
				System.out.println("연결 안 됨");
			}
			
			ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
			
			
			if(list==null){
				System.out.println("리스트 없음 ");
			}
			%>
			<table>
				<tr>
					<td>선택</td>
					<td>아이디</td>
					<td>비밀번호</td>
					<td>이름</td>
					<td>이메일</td>
					<td>등록일</td>
					<td>삭제</td>
				</tr>
				<% for(MemberVO member : list){ 
				Date getDate = member.getJoinDate();
				SimpleDateFormat sdf = new SimpleDateFormat();
				String date = sdf.format(getDate);
				%>
				<tr>
					<td><input type="checkbox" name="checkbox"></td>
					<td><a href="./server?command=read&id=<%=member.getId()%>"><%=member.getId()%></a></td>
					<td><%=member.getPwd()%></td>
					<td><%=member.getName()%></td>
					<td><%=member.getEmail()%></td>
					<td><%=date%></td>
					<td><a href="./server?command=del&id=<%=member.getId()%>">삭제</a></td>
				</tr>
				<% }%> 
			</table>
		</body>
</html>