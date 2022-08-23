<%@page import="management.member.VO.MemberVO"%>
<%@page import="management.member.DAO.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>회원 정보를 수정합니다</title>
	</head>
	<body>
	<%
	String id = request.getParameter("id");
	
	MemberDAO dao = new MemberDAO();
	MemberVO vo = dao.detailData(id);
	%>
		<form method="post" action="../process/data_update.jsp">
		<input type="hidden" name="id" value="<%=vo.getId() %>">
			<table>
			<tr>
				<td>아이디</td>
				<td><%=vo.getId()%></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pwd" value="<%=vo.getPwd() %>" required></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="<%=vo.getName() %>" required></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" value="<%=vo.getEmail() %>" required></td>
			</tr>
			<tr>
				<td><input type="submit" value="수정"></td>
			</tr>
			</table>
		</form>
	</body>
</html>