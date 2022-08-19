<%@page import="lesson.gntp.vo.LoginVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="lesson.gntp.dao.MemberDAO"%>
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
/* 내 코드 
MemberDAO dao = new MemberDAO();
ArrayList<LoginVO> list = new ArrayList<LoginVO>();
ArrayList<String> resultSet = new ArrayList<String>();
String id ="";
String pw ="";
String name = "";
String result = "";
list = dao.selectGroupA();
for(int i=0; i<list.size(); i++){
	id = list.get(i).getId();
	pw = list.get(i).getPw();
	name = list.get(i).getName();
	result = id +" "+ pw +" "+ name +"\n";
	resultSet.add(result);
	}
response.sendRedirect();
*/
ArrayList<LoginVO> list = new ArrayList<LoginVO>();
list.add(new LoginVO("admin1", "1234", "kim1"));
list.add(new LoginVO("admin2", "1234", "kim2"));
list.add(new LoginVO("admin3", "1234", "kim3"));
list.add(new LoginVO("admin4", "1234", "kim4"));
list.add(new LoginVO("admin5", "1234", "kim5"));

request.setAttribute("list", list);
System.out.println(list.size());
/* request.sendRedirect("../link/list.jsp"); */
%>
<jsp:forward page="../link/list.jsp"></jsp:forward>
</body>
</html>