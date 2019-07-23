<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="header.jsp" %>

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
	
<form action="ViewMyCart" method="post" style="float: right">
			<input class="btn btn-outline-dark" type="submit" value="View My Cart">
</form>
		

<div style="margin: 30px;">
	
		<h2>List of Products</h2>
		
		<table class="table table-striped" id="tb" border="1" cellpadding="10">
			<thead class="thead-dark">
			<tr style="text-align: center;">
				<th>Name</th>
				<th>Quantity In Stock</th>
				<th>Price (in $)</th>
				<th>Image</th>
				<th>Enter quantity to buy</th>
			</tr>
			</thead>

			<c:forEach items="${productlist}" var="i">
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
						<form action="AddToCart" method="post">
							<input type="hidden" name="itemid" value="${i.itemid}"> <input
								type="hidden" name="itemprice" value="${i.itemprice}"> <input
								type="hidden" name="itemname" value="${i.itemname}"> <input
								type="number" name="qty" placeholder="Enter quantity"
								required="required" min="1" max="${i.itemquantity}"
								style="width: 35%;"> <input type="submit"
								class="btn btn-outline-info btn-sm" value="Add to Cart"
								style="width: 35%;">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br>

	</div>
	
	
 <c:if test="${not empty addmessage}">
    <script>
    window.addEventListener("load",function(){
         alert("${addmessage}");
    })
    </script>
</c:if>
<c:if test="${not empty emptycartmessage}">
    <script>
    window.addEventListener("load",function(){
         confirm("${emptycartmessage}");
    })
    </script>
</c:if>

</body>
</html>