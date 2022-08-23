<%@page import="lib.service.vo.UserVO"%>
<%@page import="lib.service.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
		<body>
		<%
		request.setCharacterEncoding("UTF-8");
		String stdNo = request.getParameter("stdNo");
		
		UserDAO dao = new UserDAO();
		UserVO vo = dao.detailUser(stdNo);
		%>
			<form action="../process/updateUser.jsp">
				<table>
					<tr>
						<td colspan=2>회원 정보 수정</td>
					</tr>
					<tr>
						<td>학번</td>
						<td><input type="text" name="stdNo" value="<%=vo.getStdNo() %>" readonly="readonly"></td>
					</tr>
					<tr>
						<td>성명</td>
						<td><input type="text" name="stdName" value="<%=vo.getStdName() %>" readonly="readonly"></td>
					</tr>
					<tr>
						<td>전공</td>
						<td><input type="text" name="major" value="<%=vo.getMajor() %>" ></td>
					</tr>
					<tr>
						<td>나이</td>
						<td><input type="text" name="age" value="<%=vo.getAge() %>" ></td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="수정 완료">
						</td>
					</tr>
				</table>
			</form>
		</body>
</html>