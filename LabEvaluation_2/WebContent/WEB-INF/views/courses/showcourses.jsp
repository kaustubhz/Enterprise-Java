<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Courses</title>
</head>
<body>
	<table align="center" width="40%" >
		<c:forEach var="course" items="${requestScope.courses}">

			<tr>
				<th>${course.courseName}&nbsp;&nbsp;</th>
				<td><a
					href="<sp:url value='/student/register?id=${course.id}'></sp:url>">Delete
						Course</a></td>
				<td><a
					href="<sp:url value='/student/register?id=${course.id}'></sp:url>">Add
						Student</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>