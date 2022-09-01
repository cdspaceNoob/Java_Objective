<%@page import="gntp.lesson.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="gntp.lesson.dao.MemberDAO"%>
<%@page import="gntp.model2.lesson1.util.ConnectionManager"%>
<%@page import="java.sql.Connection"%>
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
	System.out.println("logic");
	MemberDAO dao = new MemberDAO();
	ArrayList<MemberVO> list = dao.selectAll();
	if(list==null){
		System.out.println("애초에 없습니다 ");
	}
	request.setAttribute("list", list);
%>
<jsp:forward page="../member/list.jsp"></jsp:forward>
</body>
</html>