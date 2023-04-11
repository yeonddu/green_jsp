<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page" />
<jsp:setProperty name="m" property="*"/>

<%
	MemberDAO memberDAO = new MemberDAO();
	memberDAO.addMember(m);
	List membersList = memberDAO.listMembers();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록창</title>
</head>
<body>
	<table align="center" width="100%">
		<tr align="center" bgcolor="#FE87BD">
			<td width="7%">아이디</td>
			<td width="7%">비밀번호</td>
			<td width="7%">이름</td>
			<td width="7%">이메일</td>
			<td width="7%">가입일</td>
		</tr>
		
		<tr align="center">
			<td>
				<jsp:getProperty name="m" property="id" />
			</td>
			<td>
				<jsp:getProperty name="m" property="pwd" />
			</td>
			<td>
				<jsp:getProperty name="m" property="name" />
			</td>
			<td>
				<jsp:getProperty name="m" property="email" />
			</td>
			<%-- <td><%= bean.getId() %></td>
			<td><%= bean.getPwd() %></td>
			<td><%= bean.getName() %></td>
			<td><%= bean.getEmail() %></td>
			<td><%= bean.getJoinDate() %></td> --%>
			
		</tr>
		<tr height="1" bgcolor="#FE87BD">
			<td colspan="5"></td>
		</tr>
	</table>
</body>
</html>