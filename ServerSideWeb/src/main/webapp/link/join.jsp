<%@page import="lesson.gntp.util.DateTimeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form method="get" action="../process/data_process.jsp">
			<label for="id">ID</label>
			<input type="text" name="id" id="id"><br>
			
			<label for="pw">PW</label>
			<input type="password" name= "pw" id="pw"><br>
			
			<input type="submit" id="submit" value="로그인">
		</form>
		<div>
		<p>현재 시각은</p>
			<!-- 서버의 현재 시간을 나타내는 코드 -->
			<%
				DateTimeService dts = new DateTimeService();
					String now = dts.getNow();
					out.print(now);
			%>
		</div>
</body>
</html>