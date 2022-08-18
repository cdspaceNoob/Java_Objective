<%@page import="java.util.Random"%>
<%@page import="java.util.RandomAccess"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page</title>
</head>
<body>
<h1>welcome</h1>
<h2>
<%
Date date = new Date();
String now = date.toLocaleString();
out.print(now);
String[] word = {"자유 ","희망 ", "조화 ", "균형 "};
Random rnd = new Random();
int index = rnd.nextInt(3);

System.out.println(now);
%>
</h2>
<span><%=word[index]%></span>

</body>
</html>