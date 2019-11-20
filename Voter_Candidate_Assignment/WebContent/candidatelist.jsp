<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidate List</title>
</head>
<body>
<h2>Hello,${sessionScope.voter.email}</h2><br/>
<jsp:setProperty property="*" name="candidate"/>
<form action="status.jsp">
<c:forEach var="candidate" items="${sessionScope.candidate.candidateList}">
<input type="radio" name="radID" value="${candidate.id}">${candidate.candidateName}</input><br/>
</c:forEach>
<input type="submit" value="Cast your vote" />
</form>
</body>
</html>