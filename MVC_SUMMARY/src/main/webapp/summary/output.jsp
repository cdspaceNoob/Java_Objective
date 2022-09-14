<%-- <%@page import="org.apache.catalina.util.URLEncoder"%> --%>
<%@page import="java.net.URLEncoder"%>
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
		BookVO vo = (BookVO)request.getAttribute("book");
	%>
		<h1>OUTPUT HERE</h1>
		<form>
			<table border=1>
				<tr>
					<td rowspan=3><img src="<%="./images/"+vo.getBook_image() %>" alt="" width=400 height=550></td>
					<td>제목: 	<%=vo.getBook_title() %></td>
				</tr>
				<tr>
					<td>저자: <%=vo.getBook_author() %></td>
				</tr>
				<tr>
					<td>가격: <%=vo.getBook_price()%></td>
				</tr>
				<tr>
					<td>다운로드:</td>
					<td><a href="download.do?fileName=<%=URLEncoder.encode(vo.getBook_attachment(), "UTF-8") %>"><%=vo.getBook_attachment() %></a></td>
				</tr>
				<tr>
					<td colspan=3><input type="submit" value="확인"></td>
				</tr>
			</table>
		</form>
	</body>
</html>