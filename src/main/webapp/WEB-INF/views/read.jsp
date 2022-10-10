<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>read</title>
</head>
<body>
	<table border ="1">
		<tr>
			<th>제목</th>
			<td>${boardVO.title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${boardVO.content}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${boardVO.writer}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${boardVO.regDate}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${boardVO.count}</td>
		</tr>
	</table>
	<br>
	<a href="/edit/${boardVO.seq}">edit</a>
	<a href="/delete/${boardVO.seq}">delete</a>
	<a href="/list">list</a>
</body>
</html>