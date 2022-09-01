<%@page import="gntp.lesson.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
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
request.setCharacterEncoding("utf-8");
MemberDAO dao = new MemberDAO();

String id 	 = request.getParameter("id");
String pwd 	 = request.getParameter("pwd");
String name  = request.getParameter("name");
String email = request.getParameter("email");

MemberVO member = new MemberVO(id, pwd, name, email, null); 

boolean flag = dao.updateOne(member);
ArrayList<MemberVO> list = null;


if(flag){
	list = dao.selectAll();
}

request.setAttribute("list", list);



%>
<jsp:forward page="../member/list.jsp"></jsp:forward>
</body>
</html>