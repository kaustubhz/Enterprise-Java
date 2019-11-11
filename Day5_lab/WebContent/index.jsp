<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Arithmetic ops</title>
</head>
<body>
<form action="add.jsp">
<label for="fnum">First Number<input type="number" name="fnum" placeholder="from 1...100"><br/>
<label for="snum">Second Number<input type="number" name="snum" placeholder="from 1...100"><br/>
<input type="submit" value="Add" /> <input type="submit" value="Substract" formaction="substract.jsp" />
<input type="reset" value="Clear" />
</form>
</body>

</html>