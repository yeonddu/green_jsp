<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${10+20 }
${10*20 }
${ture &&false }
${10>=20 }


<%!String user = "홍길동";
	String a = "교수";
	String b = "학생";
%>

<%
	if(user.equals("홍길동")) {
%>		<%=a %>
<%
	} else {
%> 		<%=b %>

<%
	}
%>
</body>
</html>