<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Screen</title>
<style>

body{

display:flex;
align-items:center;
justify-content:center;
background-color: #9ed2c5;
height:100vh;
margin:0 auto;
}

.square{

align-items:center;
background-color: #2ecc71;
height: 150px;
width:150px;

}
</style>

</head>
<body>

<div class="p1">
<font color="red">${errorMessage}</font>
<form method="post">
Name : <input type="text" name="name" />
Password : <input type="password" name="password" />
<input type="submit" />
</form>
</div>
</body>
</html>