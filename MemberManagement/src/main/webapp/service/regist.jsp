<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 정보 관리 시스템</title>
	</head>
	<body>
		<form method="post" action="../process/data_regist.jsp">
			<table>
				<tr>
					<td colspan=2>회원 가입 정보 입력</td>
				</tr>
				<tr>
					<td><label for="id">ID</label></td>
					<td><input type="text" name="id" id="id"></td>
				</tr>
				<tr>
					<td><label for="pwd">비밀번호</label></td>
					<td><input type="password" name="pwd" id="pwd"></td>
				</tr>
				<tr>
					<td><label for="pwd">이름</label></td>
					<td><input type="text" name="name" id="name"></td>
				</tr>
				<tr>
					<td><label for="pwd">Email</label></td>
					<td><input type="text" name="email" id="email"></td>
				</tr>
				<tr>
					<td colspan=2><input type="submit" value="가입"></td>
				</tr>
			</table>
		</form>
	</body>
</html>