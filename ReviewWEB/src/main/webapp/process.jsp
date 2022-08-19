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
String id = request.getParameter("id");
String pw = request.getParameter("pw");

if(id.equals("user01") && pw.equals("2345")){
	response.sendRedirect("success.jsp");
}else{
		response.sendRedirect("fail.jsp");
	}

%>
</body>
</html>