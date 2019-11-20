<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<jsp:useBean id="voter" class="beans.VoterBean" scope="session"/>
<jsp:useBean id="candidate" class="beans.CandidateBean" scope="session"/>
<body>
<h2>${sessionScope.voter.message}</h2>
<form action="validate.jsp" method="POST">
	<label for="email">Enter email<input id="email" type="email" name="email" placeholder="someone@example.com" /></label><br/> 
	<label for="pass">Enter password<input id="pass" type="password" name="pass" /></label><br/>
	<input type="submit" value="Login" /><input type="reset" value="Reset" />
</form>
</body>
</html>