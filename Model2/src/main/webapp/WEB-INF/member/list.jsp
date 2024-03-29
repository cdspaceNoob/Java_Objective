<%@page import="java.util.Date"%>
<%@page import="gntp.model2.util.DateTimeService"%>
<%@page import="gntp.model2.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
<h1>Member List</h1>

<hr/>
<%
	request.setCharacterEncoding("UTF-8");
	ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
%>
<table style="border: 3px solid lightblue">
	<tr><th>아이디</th><th>패스워드</th><th>이름</th><th>이메일</th><th>가입일자</th><th>삭제</th></tr>
<% for(MemberVO member : list){%>	
	<tr>
		<td>
			<a href="${contextPath}/member/viewMemberInfo.do?id=<%=member.getId()%>">
				<%=member.getId() %>
			</a>
		</td>
		<td><%=member.getPwd() %></td>
		<td><%=member.getName() %></td>
		<td><%=member.getEmail() %></td>
		<td><%=DateTimeService.getDateTime(DateTimeService.DATE_ONLY, new Date(member.getJoinDate().getTime()))%></td>
		<td> 
			<a href="${contextPath}/member/deleteOne.do?id=<%=member.getId()%>">
				<button>탈퇴</button>
			</a>
		</td>
	</tr>
<%} %>
</table>
<hr/>
	<a href="${contextPath}/member/joinForm.do"><button>회원 가입</button></a>
</body>
</html>