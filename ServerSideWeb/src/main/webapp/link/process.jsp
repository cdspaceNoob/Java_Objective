<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>process</title>
</head>
<body>
<h1>Process</h1>
<% 
	String id	= request.getParameter("id");
	String pw 	= request.getParameter("pw");
	String a	= request.getParameter("a");
	System.out.println("id:"+id+"/"+"pw:"+pw+a);
	if(id.equals("admin") && pw.equals("1234")){
%>
	<jsp:forward page="success.jsp"></jsp:forward>
	
		
<%}else{ %>		
		<!-- response.sendRedirect("success.jsp"); -->
	
		<!-- response.sendRedirect("fail.jsp"); -->
		<jsp:forward page="fail.jsp"></jsp:forward>
<%} %>	
</body>
</html>