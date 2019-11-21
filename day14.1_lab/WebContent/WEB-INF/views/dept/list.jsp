<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="sp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Departments</title>
</head>
<body>
<c:forEach var="dept" items="${requestScope.deptlist}">
	<p align="center"><a href="<sp:url value='/emp/register?deptartmentId=${dept.deptartmentId}' />">${dept.departName}</a></p>
</c:forEach>
</body>
</html>