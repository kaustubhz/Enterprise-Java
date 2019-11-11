<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Substract</title>
</head>
<body>
<%
request.setAttribute("result", new Integer(Integer.parseInt(request.getParameter("fnum"))-Integer.parseInt(request.getParameter("snum"))));
request.setAttribute("operation", "Substraction");
RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
rd.forward(request, response);
%>
</body>
</html>