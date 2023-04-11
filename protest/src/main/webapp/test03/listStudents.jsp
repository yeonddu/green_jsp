<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,test.*" isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8"); %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
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
	<h1>학생 정보</h1>
	<hr>
	<a href="${contextPath}/boad/studentlists.do"><p class="cls2">[새로고침]</p></a>
	<table align="center" width="100%" border="1">
		<tr align="center" bgcolor="gold">
			<td width="7%">ID</td>
			<td width="7%">USERNAME</td>
			<td width="7%">UNIV</td>
			<td width="7%">BIRTH</td>
			<td width="7%">EMAIL</td>
		</tr>
	<c:choose>
	<c:when test="${studentsList == null }">
		<tr align="center">
			<td colspan="5" width="7%">
			<p>등록된 회원이 없습니다.</p>
			</td>
		</tr>
	</c:when>
	<c:when test="${studentsList != null }">
		<c:forEach var="std" items="${studentsList }">
			<tr align="center">
				<td width="7%">${std.id }</td>
				<td width="7%">${std.userName }</td>
				<td width="7%">${std.univ }</td>
				<td width="7%">${std.birth }</td>
				<td width="7%">${std.email }</td>
			</tr>
		</c:forEach>
	</c:when>
	</c:choose>	
	</table>
		<a href="${contextPath}/boad/studentForm.do"><p class="cls2">학생 추가하기</p></a>
</body>
</html>