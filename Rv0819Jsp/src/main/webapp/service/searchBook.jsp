<%@page import="java.util.ArrayList"%>
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
	<%
		ArrayList<BookVO> list = (ArrayList<BookVO>)request.getAttribute("list");
		System.out.println("학번이 입력되었습니다 "+request.getParameter("stdNo"));
		String stdNo = (String)request.getParameter("stdNo");
		if(stdNo==null){
			response.sendRedirect("main.jsp");
		}else{
		%>		
			<body>
			<form method="get" action="../process/searchBook.jsp">
			<input type="hidden" name="stdNo" value="<%=stdNo %>">
				<table border=1>
					<tr>
						<th colspan=7>도서 조회 시스템</th>
					</tr>
					<tr>
						<td colspan=6>
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
						<td class="result">대출 가능 여부</td>
						<td class="result">옵션</td>
					</tr>
					
					<% if(list != null){
						for(int i=0; i<list.size(); i++){ 
							BookVO vo = list.get(i);
					%>
					<tr>
						<td><%=vo.getBookNo()%></td>
						<td><%=vo.getTitle()%></td>
						<td><%=vo.getAuthor()%></td>
						<td><%=vo.getPrice()%></td>
						<td><%=vo.getDate()%></td>
						<td><%=vo.getIsInShelf()%></td>
						<td><a href="../process/borrowBook.jsp?stdNo=<%=stdNo %>&title=<%=vo.getTitle()%>">대출</a></td>
					</tr>
					<% 
						}
					}
					%>
					<tr>
						<td colspan=7>
							<a href="../service/main.jsp">log out</a>
						</td>
					</tr>
				</table>
			</form>
		</body>	
		<% } %>
</html>