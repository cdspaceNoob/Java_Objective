<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>IUPUT PAGE</title>
	</head>
	<body>
		<h1>INPUT HERE</h1>
		<a href="outPut.do">결과 페이지로</a>
		<form action="outPut.do" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="bookTitle"></td>
					<td></td>
				</tr>
				<tr>
					<td>저자</td>
					<td><input type="text" name="bookAuthor"></td>
					<td></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" name="bookPrice"></td>
					<td></td>
				</tr>
				<tr>
					<td>커버</td>
					<td><input type="file" name="bookImage"></td>
					<td></td>
				</tr>
 				<tr>
					<td>첨부파일</td>
					<td><input type="file" name="bookAttach"></td>
					<td></td>
				</tr>
				<tr>
					<td><input type="submit" value="등록"></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</form>
	</body>
</html>