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
<title>뉴스 목록</title>
<style>
	#addNews {
	display:none;
	width:80%;
	border:1px solid gray;
	}
	
	#newsList{
	width:80%;
		text-align:center;
	}
	
	a {
		text-decoration:none;
	}
	
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	
	 function fn_addbtn(obj){
         document.getElementById("addNews").style.display="block";
     }
		
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
	<div id="newsList">
	
	
	<h1>뉴스 목록</h1>
	<hr>
	<table width="80%">
		<c:choose>
	<c:when test="${empty newsList }">
		<tr height="10">
			<td colspan="4">
				<p align="center"><b><span style="font-size:9pt">등록된 글이 없습니다.</span></b></p>
			</td>
		</tr>
	</c:when>
	<c:when test="${!empty newsList}">
	<c:forEach var="news" items="${newsList }">
		<tr>
			<td>[${news.aid }] 
			<a href="${contextPath }/news/viewNews.do?aid=${news.aid}">${news.title }</a>
			<br>
				${news.date }
			</td>
			<td><a href="${contextPath }/news/removeNews.do?aid=${news.aid }">x</a></td>
		</tr>
	</c:forEach>
	</c:when>
	</c:choose>
	</table>
	<input type="button" value="등록하기" onClick="fn_addbtn(this.form)">

	<form id="addNews" method="post" action="${contextPath }/news/addNews.do" enctype="multipart/form-data">
		<table>
			<tr>
				<td>제목<br>
				<input type="text" maxlength="50"name="newTitle">
				</td>
			</tr>
			<tr>
				<td>이미지<br>
				<input type="file" name="img" onchange="readUTL(this);">
				<!-- <img id="preview" src="#" width="200" height="200"/> -->
				</td>
			</tr>
			<tr>
				<td>기사내용<br>
				<textarea name="content" rows="10" cols="65" maxlength="1000"></textarea>
				</td>
			</tr>
			<tr>
				<td>
				<input type="submit" value="저장" />
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>