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
<meta charset="UTF-8">
<title>회원 정보 수정창</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap');

* {
	font-family: 'Gowun Dodum', sans-serif;
	text-decoration:none;
}

body {
	
	background-color:#FFFCED;
}
	.text_center {
		text-align:center;
	}
</style>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
	<form method="post" action="${contextPath }/member/updateMember.do?id=${memInfo.id}">
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
				<td width="200"><p>&nbsp;</p></td>
				<td width="400">
					<input type="submit" value="수정하기">
					<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>