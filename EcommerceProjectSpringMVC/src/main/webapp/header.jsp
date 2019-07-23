<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<nav class="navbar sticky-top navbar-dark bg-dark">
  	<a href="welcomeUser.jsp"><input type="button" class="btn btn-outline-info btn-lg" value="Back to Home"></a>
  	<h5 class="welcome" style="color: white;">Welcome, ${username}</h5>
  	<form action="Logout">
  		<input type="submit" class="btn btn-outline-danger btn-lg" value="Logout">
  	</form>
</nav>

</body>
</html>