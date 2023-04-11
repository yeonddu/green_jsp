<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${contextPath}/test03/mem.css">
<meta charset="UTF-8">
<title>회원 정보 수정창</title>
<style>
	.text_center {
		text-align:center;
	}
</style>
</head>
<body>
	<form method="post" action="${contextPath }/mem4.do?action=updateMember&id=${memInfo.id}">
		<h1 class="text_center">회원 정보 수정창</h1>
		<table align="center">
			<tr>
				<td width="200"><p align="right">아이디</p></td>
				<td width="400"><input type="text" name="id" value="${memInfo.id }" disabled="disabled"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">비밀번호</p></td>
				<td width="400"><input type="password" name="pwd" value="${memInfo.pwd }"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이름</p></td>
				<td width="400"><input type="text" name="name" value="${memInfo.name }"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이메일</p></td>
				<td width="400"><input type="text" name="email" value="${memInfo.email }"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="수정하기">
				<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>