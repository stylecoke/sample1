<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>delete</title>
</head>
<body>
	<form action="/delete" method="post">
		<table border="1">
			<tr>
				<th><label for="seq">NO</label></th>
				<td>
					<input type="text" id="seq" name="seq" value="${seq}"/>
				</td>
			</tr>
			<tr>
				<th><label for="pwd">Password</label></th>
				<td>
					<input type="password" id="pwd" name="pwd" size="21"/>
				</td>
			</tr>
		</table>
		<br/>
		<input type="submit" value="submit" style="width:60px; height:22px;"/>
		<a href="/read/${seq}">cancel</a>
		<div><br/>${msg}</div>
	</form>
</body>
</html>