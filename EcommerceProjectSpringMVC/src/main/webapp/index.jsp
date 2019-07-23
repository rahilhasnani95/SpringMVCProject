<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body class="bg" style="text-align: center; margin-top: 50px;" background= "../LandingStock_image_26">
<h1>Login Form</h1>

	<form class="indexform" action="checkUser" method="post">
		<br><br>
		Enter Username : <input type="text" name="username" required="required"> <br><br>
		Enter Password : <input type="password" name="password" required="required"><br><br>
		<input class="btn btn-outline-success btn-lg" type="submit" value="Login">
			<a href="register.jsp"><input type="button" class="btn btn-outline-info btn-lg" value="New User? Register"></a>
		
	</form>
	
	<br>
<h5 style="color: green">${regsuccessmsg}<h5>

<h5 style="color: red">${invalidcredentialsmsg}</h5>

</body>
</html>