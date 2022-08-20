<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>도서 조회 시스템</title>
		<link rel="text/stylesheet" href="../css/searchBook.css">
	</head>
	<body>
		<table border=1>
			<tr>
				<th colspan=5>도서 조회 시스템</th>
			</tr>
			<tr>
				<td colspan=5>
					<label for="search_book_name">검색</label>
					<input style="text" name="book_name" id="search_book_name" placeholder="제목을 입력하세요">
				</td>
			</tr>
			<tr id="result">
				<th class="result">1</th>
				<th class="result">2</th>
				<th class="result">3</th>
				<th class="result">4</th>
			</tr>
		</table>
	</body>
</html>