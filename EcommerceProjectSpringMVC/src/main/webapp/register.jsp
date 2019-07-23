<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body class="bg" style="text-align: center; margin-top: 50px;" background="LandingStock_image_26">
<h1>Registration Form</h1>

	<form class="indexform" action="registerUser" method="post" >
		<br><br>		
<!--  		Enter Username (Email) :  <input type="email" name="username" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required="required"> <br><br> 
 --> 		
 		Enter Username : <input type="text" name="username" required="required"> <br><br>
 		Enter Password : <input type="password" name="password" required="required"><br><br>
		<input class="btn btn-outline-success btn-lg" type="submit" value="Register">
					
		<a href="index.jsp"><input type="button" class="btn btn-outline-info btn-lg" value="Back to Login"></a>
		
	</form>
	<br>
<p style="color: red"> ${userexistsmessage} </p>
	
	
</body>
</html>