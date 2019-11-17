<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate List</title>
</head>

<body>
	<h4 align="center">Candidate List</h4>
	<form action="status.jsp" method="GET">
		<c:forEach var="c" items="${sessionScope.candidate.candidates}">
			<input type="radio" name="radbtn" value="${c.id}">${c.name}&nbsp;&nbsp;&nbsp;${c.party}</input>
			<br />
		</c:forEach>
	</form>
</body>
</html>