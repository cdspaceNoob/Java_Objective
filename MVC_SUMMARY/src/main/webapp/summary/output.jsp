<%@page import="gntp.lesson.mvc.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>OUTPUT PAGE</title>
		<style>
			
			td, tr{
				border: solid 1px;
			}
			
			table{
				border-collapse: collapse;
			}
			
			
		</style>
		
	</head>
	<body>
	<%
		BookVO vo = (BookVO)request.getAttribute("vo");
	%>
		<h1>OUTPUT HERE</h1>
		<form>
			<table border=1>
				<tr>
					<td rowspan=3><img src="./images/ab.jpeg" alt="" width=400 height=550></td>
					<td>제목: 	<%="제목" %></td>
				</tr>
				<tr>
					<td>저자: <%="저자" %></td>
				</tr>
				<tr>
					<td>가격: <%="가격" %></td>
				</tr>
				<tr>
					<td colspan=3><input type="submit" value="확인"></td>
				</tr>
			</table>
		</form>
	</body>
</html>