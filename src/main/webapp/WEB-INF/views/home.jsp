<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
	<meta charset="UTF-8">
	<title>home</title>
</head>
<body>
    <h1><spring:message code="home.title"/></h1>
 	<a href="/list"><spring:message code="home.list"/></a>
 	<a href="/write"><spring:message code="home.write"/></a>
</body>
</html>