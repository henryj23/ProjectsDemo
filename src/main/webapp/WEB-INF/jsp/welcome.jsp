<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>Hello <%= request.getParameter("name") %></h3>

<br><br>

<h4>Your password is <%=request.getParameter("password") %></h4>

<br>

<a href="/getallproject">Projects Available</a> <br>

<a href="/list-employees">Resources Available</a>

</body>
</html>