<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*" isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member information</title>
<style>
	.cls1 {
	font-size:40px;
	text-align:center;
	}
	.cls2 {
	text-align:center;
	}
</style>
</head>
<body>
	<table align="center" width="100%" border="1">
		<tr align="center" bgcolor="gold">
			<td width="7%">ID</td>
			<td width="7%">PWD</td>
			<td width="7%">NAME</td>
			<td width="7%">EMAIL</td>
			<td width="7%">JOINDATE</td>
		</tr>
	<c:choose>
	<c:when test="${membersList == null }">
		<tr align="center">
			<td colspan="5" width="7%">
			<p>등록된 회원이 없습니다.</p>
			</td>
		</tr>
	</c:when>
	<c:when test="${membersList != null }">
		<c:forEach var="mem" items="${membersList }">
			<tr align="center">
				<td width="7%">${mem.id }</td>
				<td width="7%">${mem.pwd }</td>
				<td width="7%">${mem.name }</td>
				<td width="7%">${mem.email }</td>
				<td width="7%">${mem.joinDate }</td>
			</tr>
		</c:forEach>
	</c:when>
	</c:choose>	
	</table>
	<a href="#"><p class="cls2">회원 가입하기</p></a>
</body>
</html>