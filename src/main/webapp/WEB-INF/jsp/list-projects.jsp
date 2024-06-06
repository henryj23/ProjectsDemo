<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*, java.util.*, henryjames.employeeprojects.*" %>

<%@include file="apphome.jsp" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Projects</title>
</head>
<body>
<%

	List<Project> projects = (List<Project>)request.getAttribute("projects");

%>

<div class="container">
<table class ="table table-hover table-striped" >
<caption><h2>List of Projects</h2></caption>
<thead class="thead-dark">
<tr>


<th scope="col">ID</th>
<th>Project Title</th>
<th>Technology Used</th>
</tr>
</thead>
<%


for(Project u: projects) {


%>

<tr>

<td ><%= u.getId() %></td>
<td ><%= u.getProjectname() %></td>
<td><%= u.getTechnologyUsed() %></td>

</tr>

<% } %>

</table>
</div>
<br><br>
</body>
</html>