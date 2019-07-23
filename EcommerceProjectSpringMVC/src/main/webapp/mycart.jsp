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
	
<br>

<div style="margin: 20px;">
	
	<h2>My Cart </h2>
		<table class="table table-striped" id="tb" border="1" cellpadding="10">
			<thead class="thead-dark">			
			<tr>
				<th>Item Name</th>
				<th>Quantity in Cart</th>
				<th>Total Price of this Item</th>
				<th>Delete Item</th>
			</tr>
			</thead>
			
			<c:set var="finaltotal" value="${0}"/>
			<c:forEach items="${cartlist}" var="i">
				<tr>
					<td><c:out value="${i.itemname}" /></td>
					<td><c:out value="${i.itemquantity}" /></td>
					<td><c:out value="${i.totalprice}" /></td>	
					<c:set var="finaltotal" value="${finaltotal + i.totalprice}" />
					
					 <td style="text-align: center;">
			 		<form action="DeleteItem" method="post">
						<input type="hidden" name="itemid" value="${i.itemid}">
						<input type="hidden" name="itemname" value="${i.itemname}">	
						<input type="submit" class="btn btn-outline-danger btn-sm" value="Remove Item" style="width: 40%;" >					
					</form>
					</td>	
						
				</tr>
				
			</c:forEach>
			
		</table>
		<br>
	<h4> Final Total : $ ${finaltotal} </h4><br>

 	<div style="display: inline-flex;" >
		<form action="SeeProducts" method="post">
			<input type="submit" class="btn btn-info btn-lg" value="Continue Shopping">
		</form>

		<form action="Checkout" method="post" style="margin-left: 20px;">
			<input type="hidden" name="finaltotalbill" value="${finaltotal}">
			<input class="btn btn-dark btn-lg" type="submit" value="CheckOut">
		</form>
	</div>
</div>

<c:if test="${not empty itemsoldoutmessage}">
    <script>
    window.addEventListener("load",function(){
         confirm("${itemsoldoutmessage}");
    })
    </script>
</c:if>

<c:if test="${not empty finalbillmessage}">
    <script>
    window.addEventListener("load",function(){
         confirm("${finalbillmessage}");
    })
    </script>
</c:if>

<c:if test="${not empty cantcheckoutmessage}">
    <script>
    window.addEventListener("load",function(){
         confirm("${cantcheckoutmessage}");
    })
    </script>
</c:if>

</body>
</html>