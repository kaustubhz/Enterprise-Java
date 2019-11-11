<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Addition</title>
</head>
<body>
<%-- <label> First number: <%= request.getParameter("fnum")%></label><br/>
<label> Second number: <%= request.getParameter("snum")%></label><br/>
 --%>
 <%-- <%out.flush(); %> --%>
 <label> First number: ${param.fnum}</label><br/>
<label> Second number: ${param.snum}</label><br/>
<%-- <label> Addition is: <%= Integer.parseInt(request.getParameter("fnum"))+Integer.parseInt(request.getParameter("snum")) %> --%>
<%-- <label> Addition is: <%= Integer.parseInt(${param.fnum})+Integer.parseInt(${param.fnum})%> --%>
</body>
<%
	request.setAttribute("result", new Integer(Integer.parseInt(request.getParameter("fnum"))+Integer.parseInt(request.getParameter("snum"))));
	request.setAttribute("operation", "Addition");
	RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
			rd.forward(request, response);
%>
</html>