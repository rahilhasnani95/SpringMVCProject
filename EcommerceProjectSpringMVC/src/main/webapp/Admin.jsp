<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
tr
{
text-align: center;
}
</style>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");	

	if(session.getAttribute("username") == null)
	{
		response.sendRedirect("index.jsp");
	}
	%>
	
<nav class="navbar sticky-top navbar-dark bg-dark">
  	<a href="welcomeAdmin.jsp"><input type="button" class="btn btn-outline-info btn-lg" value="Back to Home"></a>
  	<h5 class="welcome" style="color: white;">Welcome, ${username}</h5>
  	<form action="Logout">
  		<input type="submit" class="btn btn-outline-danger btn-lg" value="Logout">
  	</form>
</nav>

<div style="margin-left: 20px;">
		<h2>List of Products</h2>
		<table class="table table-striped" id="tb" border="1" cellpadding="10">
			<thead class="thead-dark">			
			<tr style="text-align: center;">
				<th>Name</th>
				<th>Quantity In Inventory</th>
				<th>Price (in $)</th>
				<th>Image</th>
				<th>Update quantity</th>
			</tr>
			</thead>

			<c:forEach items="${allprodlist}" var="i">
				<tr>
					<td><c:out value="${i.itemname}" /></td>
					<td><c:out value="${i.itemquantity}" /></td>
					<td><c:out value="${i.itemprice}" /></td>

					<td style="text-align: center;">
						<form action="viewimage.jsp">
							<input type="hidden" name="itemid" value="${i.itemid}"> <input
								type="submit" class="btn btn-outline-dark btn-sm"
								value="View Image" style="width: 110px">
						</form>
					</td>

					<td style="text-align: center;">
						<form action="updateProductAdmin" method="post">
							<input type="hidden" name="itemid" value="${i.itemid}"> 
							<input type="hidden" name="itemprice" value="${i.itemprice}"> 
							<input type="hidden" name="itemname" value="${i.itemname}"> 
							<input type="number" name="qty" placeholder="Update quantity" required="required" min="1" max="100" style="width: 30%; margin-right: 15px;"> 
							<input type="submit" class="btn btn-outline-info btn-sm" value="Update Quantity" style="width: 30%;">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	
<p style="color: red">${adminupdatemsg}</p>

	</div>
</body>
</html>