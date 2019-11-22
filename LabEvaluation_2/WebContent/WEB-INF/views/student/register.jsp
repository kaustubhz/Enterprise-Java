<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="sp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<sp:form method="POST">
 name<sp:input  path="studentName"/>
 email<sp:input path="studentEmail"/>
 CGPA<sp:input path="studentCGPA"/>
 DoB<sp:input path="studentDoB"/>
 <sp:button value="Submit" ></sp:button>
</sp:form>
</body>
</html>