<%@page import="gntp.lesson.dao.MemberDAO"%>
<%@page import="gntp.lesson.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>generate member info</title>
</head>
<body>
<%
String id = request.getParameter("id");
MemberDAO dao = new MemberDAO();
MemberVO member = dao.selectOne(id);
request.setAttribute("member", member);

%>
<jsp:forward page="../member/viewMemberInfo.jsp"></jsp:forward>
</body>
</html>