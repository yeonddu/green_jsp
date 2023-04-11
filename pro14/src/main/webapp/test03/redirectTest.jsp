<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" import="sec01.ex01.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<% 
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:redirect url="/test03/member1.jsp">
<c:param name="id" value="${'song' }"/>
<c:param name="pwd" value="${'4321' }"/>
<c:param name="name" value="${'송연수' }"/>
<c:param name="email" value="${'song@test.com' }"/>
</c:redirect>
</body>
</html>