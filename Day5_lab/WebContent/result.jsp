<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${requestScope.operation}</title>
</head>
<body>
<label>First number is: ${param.fnum}</label><br/>
<label>Second number is: ${param.snum}</label><br/>
<label>The result is
 ${requestScope.result}
 </label>
</body>
</html>