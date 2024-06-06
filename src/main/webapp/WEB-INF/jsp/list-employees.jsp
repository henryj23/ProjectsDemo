<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*,java.util.*,henryjames.employeeprojects.*" %>
    
    <%@include file="apphome.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

List<Employee> employees = (List<Employee>)request.getAttribute("employees");

%>


<div class="container">

	<table class = "table table-hover table-striped">
		<caption><h2>List Of Projects</h2></caption>
		<thead class = "thead-dark">
		<tr>
		
			<th scope="col">ID</th>
			<th>Employee Name</th>
			<th>Skill Set</th>
			
			</tr>
			</thead>
			
			<%
			
			for(Employee u: employees) {
				
			
			
			%>
			
				<tr>

					<td ><%= u.getId() %></td>
					<td ><%= u.getName() %></td>
					<td><%= u.getProjects() %></td>

				</tr>


<%} %>
		
	
	
	</table>






</div>

</body>
</html>