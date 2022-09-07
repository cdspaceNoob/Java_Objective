<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Write Board</title>
</head>
	<body>
		<form action="" method="post">
			<table>
				<tr>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td><textarea rows="5" cols="100"></textarea></td>
				</tr>
				<tr>
					<td><input type="hidden" name="current_seq" value="a"></td>
				</tr>
				<tr>
					<td><input type="hidden" name="next_seq" value=" "></td> <!-- 다음 댓글이 존재하지 않을 때, next_seq는 비어 있다. --> 
				</tr>
				<tr>
					<td><input type="submit" value="작성 완료"></td>
				</tr>
			</table>
		</form>
	</body>
</html>