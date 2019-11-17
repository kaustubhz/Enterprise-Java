<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<jsp:useBean id="voter" class="beans.VoterBean" scope="session" />
<jsp:useBean id="candidate" class="beans.CandidateBean" scope="session" />
<body>
<form action="validate.jsp" method="post">
	<label for="email"> Enter email<input id="email" type="email" name="email" /></label><br/>
	<label for="password"> Enter password<input id="pass" type="password" name="pass" /></label><br/>
	<input type="submit" value="Submit" />
	<input type="reset" value="Reset" />
</form>
</body>
</html>