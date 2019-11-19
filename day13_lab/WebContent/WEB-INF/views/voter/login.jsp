<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>

<body>
<h2>${requestScope.message}</h2>
<form  method="post">
	<label for="email"> Enter email<input id="email" type="email" name="email" placeholder="someone@example.com" /></label><br/>
	<label for="password"> Enter password<input id="pass" type="password" name="password" /></label><br/>
	<input type="submit" value="Submit" />
	<input type="reset" value="Reset" />
</form>
</body>
</html>