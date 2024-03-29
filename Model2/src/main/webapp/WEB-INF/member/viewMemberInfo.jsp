<%@page import="gntp.model2.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view Member Info</title>
</head>
<body>
<%
	MemberVO member = (MemberVO)request.getAttribute("member");
	String id = request.getParameter("id");
%>
<form action="${contextPath}/member/updateOne.do" method="post">
	ID: <input type="text" name="id" readonly="readonly" value="<%=member.getId()%>"><br>
	PWD: <input type="password" name="pwd" readonly="readonly" value="<%=member.getPwd()%>"><br>
	NAME: <input type="text" name="name" value="<%=member.getName()%>"><br>
	EMAIL: <input type="text" name="email" value="<%=member.getEmail()%>"><br>
	JOINDATE: <input type="text" name="joinDate" value="<%=member.getJoinDate()%>"><br>
	<input type="submit" value="수정"><br>
</form>
</body>
</html>