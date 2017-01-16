<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<h2>Creation d'un utilisateur</h2>
<s:url value="/public/register" var="registerUrl" />
<sf:form action="${registerUrl}" method="post">
	<label for="username" >votre login</label>
	<input type="text" name="username" id="username"><br />
	<label for="email" >votre email</label>
	<input type="text" name="email" id="email"><br />
	<label for="password" >votre mot de passe</label>
	<input type="password" name="password" id="password"><br />
	<label for="confirm" >confirmation mot de passe</label>
	<input type="password" name="confirm" id="confirm"><br />
	<input type="submit" value="creer compte" />
</sf:form>
</body>
</html>