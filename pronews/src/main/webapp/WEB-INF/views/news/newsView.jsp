<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뉴스 보기</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#preview').attr('src', e.target.result);
            };
            reader.readAsDataURL(input.files[0]);
		}
	}
</script>
</head>
<body>
	<table align="center" width="80%">
		<h1>${newsInfo.title }</h1>
		
		<c:if test="${not empty article.imageFileName && article.imageFileName != 'null' }">
		<tr>
			<td width="150" align="center" bgcolor="#FF9933" rowspan="2">이미지</td>
			<td>
				<input type="hidden" name="originalFileName" value="${newsInfo.img }"/>
				<img src="${contextPath }/download.do?articleNO=${newsInfo.aid}&imageFileName=${newsInfo.img}" id="preview"/><br>
			</td>
		</tr>
		<tr>
			<td><input type="file" name="imageFileName" id="i_imageFileName" disabled onchange="readURL(this);"/></td>
		</tr>
		</c:if>
		
	<tr>
		<td>Date: <fmt:formatDate value="${newsInfo.date }" /></td>
	</tr>
	<tr>
		<td>${newsInfo.content }</td>
	</tr>		
	
	</table>
</body>
</html>