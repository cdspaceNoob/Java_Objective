<%@page import="lib.service.util.DateTimeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../css/main.css">
		<meta charset="UTF-8">
		<title>B - Library</title>
	</head>
	<body>
		<form method="post" action="../process/loginValidation.jsp">
			<div class="main">
				<table>
					<tr>
						<th colspan = 3>도서 조회 시스템</th>
					</tr>
					<tr>
						<td>학번</td>
						<td colspan = 2>
							<input type="text" name="stdNo">
						</td>
					</tr>
					<tr>
						<td>나이</td>
						<td colspan = 2>
							<input type="password" name="age">
						</td>
					</tr>
					<tr>
						<td colspan = 3>
							<input type="submit" value="login">
						</td>
					</tr>
					<tr>
						<td colspan = 3>
						현재 시각은<br><%=DateTimeService.getNow()%>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>