<%@page import="java.util.ArrayList"%>
<%@page import="management.member.VO.MemberVO"%>
<%@page import="management.member.DAO.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 목록 조회 페이지</title>
	</head>
	<body>
	<form method="get" action="../process/data_del.jsp">
		<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>등록일</th>
			<th>옵션</th>	
		</tr>
		
			<%
			ArrayList<MemberVO> list = new ArrayList<MemberVO>();
			MemberDAO dao = new MemberDAO();
			list = dao.viewData();
			for(int i=0; i<list.size(); i++){
				MemberVO vo = list.get(i);
				String id = vo.getId();
				String pwd = vo.getPwd();
				String name = vo.getName();
				String email = vo.getEmail();
				String date = vo.getJoinDate();
				%>
				<tr>
					<td><input type="text" readonly="readonly" name="id" value="<%=id%>"></td>
					<td><input type="text" readonly="readonly" value="<%=pwd%>"></td>
					<td><input type="text" readonly="readonly" value="<%=name%>"></td>
					<td><input type="text" readonly="readonly" value="<%=email%>"></td>
					<td><input type="text" readonly="readonly" value="<%=date%>"></td>
					<td><input type="submit" value="삭제"></td>
				</tr>
				
			<% } %>
		</table>
		</form>
		
		<a href="regist.jsp">등록 화면으로 바로가기</a>
		</body>
</html>