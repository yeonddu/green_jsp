<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
		<table border="1" width="50%" align="center">
			<tr align="center">
				<td>아이디</td>
				<td>비밀번호</td>
			</tr>
			<tr align="center">
			<!-- 컨트롤러에서 바인딩해 넘어온 회원정보 출력 -->
				<td>${userID }</td>
				<td>${passwd }</td>
			</tr>
		</table>
</body>
</html>