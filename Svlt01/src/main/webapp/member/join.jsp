<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form method="post" action="/Svlt01/server?mode=create">
			<table>
			<tr>
				<td>아이디 </td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호 </td>
				<td><input type="text" name="pwd"></td>
			</tr>
			<tr>
				<td>이름 </td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>이메일 </td>
				<td><input type="text" name="email"></td>
			</tr>
			<!-- <tr>
				<td>등록일 </td>
				<td><input type="text" name="joinDate" readonly="readonly"></td>
			</tr> -->
			<tr>
				<td colspan=5><input type="submit" value="생성"></td>
			</tr>
			</table>
		</form>
	</body>
</html>