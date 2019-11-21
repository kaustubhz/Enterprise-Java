<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Employee Form</title>
</head>
<body>
	<sp:form method="post" modelAttribute="employee">
		<table>
			<tr>
				<td>Enter Employee Name</td>
				<td><sp:input path="empName" /></td>
			</tr>
			<tr>
				<td>Enter Employee Email</td>
				<td><sp:input path="empEmail" /></td>
			</tr>
			<tr>
				<td>Enter Salary</td>
				<td><sp:input type="number" path="empSalary" /></td>
			</tr>
			<tr>
				<td>Enter Date</td>
				<td><sp:input type="date" path="empDOB" /></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Hire Employee" />
	</sp:form>

</body>
</html>