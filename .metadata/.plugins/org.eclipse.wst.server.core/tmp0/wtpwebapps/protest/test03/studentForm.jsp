<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${contextPath }/boad/addStudent.do" method="post">
	<h1>학생 추가</h1>
	<hr>
	이름 <input type="text" name="userName"><br>
	대학 <input type="text" name="univ"><br>
	생일 <input type="text" name="birth"><br>
	이메일 <input type="text" name="email"><br>
	<input type="submit" value="등록">
	</form>
</body>
</html>