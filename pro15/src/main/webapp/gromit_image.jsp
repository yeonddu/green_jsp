<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String imgName = request.getParameter("imgName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그로밋이미지</title>
</head>
<body>
	<br><br>
	<h1>이름은 <%=name %>입니다.</h1>
	<br><br>
	<img src="images/<%=imgName %>" width=500 height=300/>	
</body>
</html>