<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> 여기에서 도서 등록 </title>
	</head>
	<body>
		<form action="../create.do" method="post" enctype="multipart/form-data">
			<table border=1>
				<tr>
					<td>제목</td>
					<td><input type="text" name="book_title"></td>
				</tr>
				<tr>
					<td>작가</td>
					<td><input type="text" name="book_author"></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" name="book_price"></td>
				</tr>
				<tr>
					<td>커버</td>
					<td><input type="file" name="book_image"></td>
				</tr>
				<tr>
					<td>파일</td>
					<td><input type="file" name="book_attachment"></td>
				</tr>
				<tr>
					<td colspan=2><input type="submit" value="등록"></td>
				</tr>
			</table>
		</form>
	</body>
</html>