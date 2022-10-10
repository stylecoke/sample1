<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>edit</title>
</head>
<body>
	<form:form modelAttribute="boardVO" method="post">
		<table border="1">
			<tr>
				<th><form:label path="title">제목</form:label></th>
				<td>
					<form:input type="text" path="title" />
					<form:errors path="title" />
				</td>
			</tr>
			<tr>
				<th><form:label path="content">내용</form:label></th>
				<td>
					<form:input type="text" path="content" />
					<form:errors path="content" />
				</td>
			</tr>
			<tr>
				<th><form:label path="writer">작성자</form:label></th>
				<td>
					<form:input type="text" path="writer"/>
					<form:errors path="writer" />
				</td>
			</tr>
			<tr>
				<th><label for="password">비밀번호</label></th>
				<td>
					<input type="password" id="pwd" name="pwd" size="21"/>
					${msg}
				</td>
			</tr>
		</table>
		<br>
		<input type="submit" value="submit" style="width:60px; height:22px;">
		<a href="/list">list</a>
	</form:form>
</body>
</html>