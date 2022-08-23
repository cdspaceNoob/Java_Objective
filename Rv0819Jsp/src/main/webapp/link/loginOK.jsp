<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 조회 시스템: 로그인</title>
</head>
<body>
<h1>Login OK</h1>
<%
request.setCharacterEncoding("UTF-8");
String stdNo = (String)request.getParameter("stdNo");
/* System.out.println(stdNo); */
/* System.out.println(stdNo.getClass().getName()); */
%>
<a href="../service/main.jsp">log out</a>
<br>
<a href="../service/searchBook.jsp?stdNo=<%=stdNo%>">도서 조회 시스템 바로가기</a>
<br>
<a href="../link/accountConfig.jsp?stdNo=<%=stdNo%>">회원 정보 수정</a>
<%-- <form>
<input type="hidden" name="stdNo" value="<%=stdNo%>">
<input type="submit" value="회원 정보 수정">
</form> --%>
</body>
</html>