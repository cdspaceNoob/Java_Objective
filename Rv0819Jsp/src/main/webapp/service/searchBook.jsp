<%@page import="lib.service.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>도서 조회 시스템</title>
		<link rel="stylesheet" href="../css/searchBook.css">
	</head>
		<body>
		<%
		BookVO vo = (BookVO)request.getAttribute("vo");
		%>
			<form method="get" action="../process/searchBook.jsp">
				<table border=1>
					<tr>
						<th colspan=5>도서 조회 시스템</th>
					</tr>
					<tr>
						<td colspan=4>
							<input style="text" name="book_name" id="search_book_name" placeholder="제목을 입력하세요">
						</td>
						<td>
							<input type="submit" value="검색">
						</td>
					</tr>
					<tr id="result">
						<td class="result">도서 번호</td>
						<td class="result">제목 </td>
						<td class="result">지은이 </td>
						<td class="result">가격 </td>
						<td class="result">등록 날짜 </td>
					</tr>
					<% if(vo != null){%>
					<tr>
						<td><%=vo.getBookNo()%></td>
						<td><%=vo.getTitle()%></td>
						<td><%=vo.getAuthor()%></td>
						<td><%=vo.getPrice()%></td>
						<td><%=vo.getDate()%></td>
					</tr>
					<% } %>
				</table>
			</form>
		</body>
</html>