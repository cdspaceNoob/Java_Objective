<%@page import="lesson.gntp.vo.LoginVO"%>
<%@page import="java.util.ArrayList"%>
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
	ArrayList<LoginVO> list = (ArrayList<LoginVO>)request.getAttribute("list");
	System.out.println(list.size());
	/* out.print("<table>");
	for(LoginVO vo : list){
		//System.out.println(vo.getId()+" "+vo.getPw()+" "+vo.getName()+"\n");
		out.print("<tr>");
		out.println("<td>"+vo.getId()+"</td><td>"+vo.getPw()+"</td><td>"+vo.getName()+"</td>");
		out.print("</tr>");
	}
	out.print("</table>");  */
	%>
	<table>
	<%for(LoginVO vo : list){%>
		<tr>
			<td><%=vo.getId()%></td>
			<td><%=vo.getPw()%></td>
			<td><%=vo.getName()%></td>
		<tr>
	<%}%>
	</table>
	</body>
</html>