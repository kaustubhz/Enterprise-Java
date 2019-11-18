<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Status</title>
</head>
<body>

<c:if test="${!sessionScope.voter.objVoter.status=='YES'}">
<jsp:setProperty property="*" name="candidate" />
<p>${sessionScope.voter.updateStatus()}</p>
<p>${sessionScope.candidate.updateVotes()}</p>
<%session.invalidate(); %>
</c:if>
<a href="login.jsp">Click to login</a>
</body>
</html>