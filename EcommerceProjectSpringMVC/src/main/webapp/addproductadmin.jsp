<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style type="text/css">
p {
color: green;
}
h5 {
color: red;
}
</style>
</head>
<body class="bg" style="text-align: center; margin-top: 50px;" background="images/LandingStock_image_26.jpg">
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");	

	if(session.getAttribute("username") == null)
	{
		response.sendRedirect("index.jsp");
	}
	%>
<h2>Add Product Form</h2>

	<form class="indexform" action="addNewProduct" method="get" >
		<br><br>
		Enter Product Name : <input type="text" name="itemname" required="required"> <br><br>
		Enter Product Price : <input type=number name="itemprice" required="required"><br><br>
		Enter Product Quantity : <input type="number" name="itemquantity" required="required"><br><br>
		
		<input class="btn btn-outline-success btn-lg" type="submit" value="Add Product">
	</form>
<p style="color: green">${adminaddproductmsg}</p>

</body>
</html>