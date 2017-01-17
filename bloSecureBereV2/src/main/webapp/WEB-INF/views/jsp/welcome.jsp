
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bonjour</title>
<s:url value="/logout" var="logout" />
<s:url value="/post" var="listPost" />
<s:url value="" var="" />

<link href="${coreStyle}" rel="stylesheet" />
</head>
<body>
<s:url value="/logout" var="logoutUrl" />
<sf:form action="${logoutUrl}" method="post">
	<input type="submit" value="se delogguer" />
</sf:form>

<h2>${bienvenue venerable user}</h2>
<a href=""/>
</body>
</html>