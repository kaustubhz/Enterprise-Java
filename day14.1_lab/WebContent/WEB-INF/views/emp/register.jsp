<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">Hire employee</h2>
	<form  method="POST">
		<table align="center" cellspacing=2>
			<tr>
				<th><label for="empName"> Employee name </label></th>
				<td><input id="ename" type="text" name="empName" /></td>
			</tr>
			<tr>
				<th><label for="empEmail"> email </label></th>
				<td><input id="email" type="email" name="empEmail" /></td>
			</tr>
			<tr>
				<th><label for="empSalary">Salary </label></th>
				<td><input id="salary" type="number" name="empSalary" /></td>
			</tr>
			<tr>
				<th><label for="empDOB">DOB </label></th>
				<td><input id="dob" type="date" name="empDOB" /></td>
			</tr>
			<tr>
				<td><input  type="submit" value="Submit" /></td>
				<td><input  type="reset" name="Reset" /></td>
			</tr>
	</form>
</body>
</html>