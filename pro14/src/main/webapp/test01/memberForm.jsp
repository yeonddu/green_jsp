<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입창</title>
<style>
	div {
	text-align:center;
	margin:0px auto;
	}
	label {
	width:150px;
	
	}
	input {
	margin:10px;
	}
</style>
</head>
<body>
	<div>
	<form method="post" action="member1.jsp">
	<h1 style="text-align:center">회원 가입창</h1>
	<label>아이디</label><input type="text" name="id"><br>
	<label>비밀번호</label><input type="password" name="pwd"><br>
	<label>이름</label><input type="text" name="name"><br>
	<label>이메일</label><input type="text" name="email"><br>
	<input type="submit" value="가입하기">
	<input type="reset" value="다시입력">
	</form>
	</div>
</body>
</html>