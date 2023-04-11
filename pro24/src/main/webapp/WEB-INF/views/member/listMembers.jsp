<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 출력창</title>
<!-- 
<c:choose>
<c:when test='${msg=="modified"}'>
	<script type="text/javascript">
		window.onload = function() {
			alert("회원을 수정했습니다.");
		}
	</script>
</c:when>
<c:when test='${msg=="addMember"}'>
	<script type="text/javascript">
		window.onload = function() {
			alert("회원을 등록했습니다.");
		}
	</script>
</c:when>
<c:when test='${msg=="deleted"}'>
	<script type="text/javascript">
		window.onload = function() {
			alert("회원을 삭제했습니다.");
		}
	</script>
</c:when>
</c:choose> -->

<%-- <link rel="stylesheet" href="${contextPath}/resources/css/style.css"> --%>
<style>
@import url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap');

* {
	font-family: 'Gowun Dodum', sans-serif;
	text-decoration:none;
}

body {
	
	background-color:#FFFCED;
}

table {
border-collapse: collapse;
}

</style>
 </head>
<body>
	<table align="center" width="80%" border="1">
		<tr align="center" bgcolor="gold">
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>이메일</td>
			<td>가입일</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>

		<c:forEach var="member" items="${membersList }">
			<tr align="center">
				<td>${member.id }</td>
				<td>${member.pwd }</td>
				<td>${member.name }</td>
				<td>${member.email }</td>
				<td>${member.joinDate }</td>
				
				<!-- 수정하기 추가 -->
				<td><a href="${contextPath }/member/modMember.do?id=${member.id }">수정</a></td>
				
				<td><a href="${contextPath }/member/removeMember.do?id=${member.id }">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="${contextPath}/member/memberForm.do"><h1 style="text-align:center">회원가입</h1></a>
</body>
</html>