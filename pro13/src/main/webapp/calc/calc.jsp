<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.calc.*" isELIgnored="false"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="c" class="sec01.calc.NumberBean" scope="page" />
<jsp:setProperty name="c" property="*"/>

<%
	NumberDAO numberDAO = new NumberDAO();
	numberDAO.addNumber(c);
	List numbersList = numberDAO.listNumbers();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산결과 - useBean</title>
</head>

<body>
<h1>계산결과</h1>
	<table border="1" align="center" >
		<tr align="center" bgcolor="gold">
			<td width="20%"><b>num1</b></td>
			<td width="20%"><b>operation</b></td>
			<td width="20%"><b>num2</b></td>
			<td width="20%"><b>result</b></td>
		</tr>
				<%
			if(numbersList.size() == 0) {
		%>
		<tr>
			<td colspan="5">
				<p align="center"><b><span style="font-size:9pt;">
				계산한 기록이 없습니다.</span></b></p>
			</td>
		</tr>
		<%
			} else {
				for (int i=0; i<numbersList.size(); i++) {
					NumberBean bean = (NumberBean) numbersList.get(i);
		%>
		<tr align="center">
			<td><%=bean.getNum1() %></td>
			<td><%=bean.getOp() %></td>
			<td><%=bean.getNum2()%></td>
			<td><%=bean.getValue() %></td>
		</tr>
		<%
				} // end for
				
			} // end if
		%>
	</table>
</body>
</html>