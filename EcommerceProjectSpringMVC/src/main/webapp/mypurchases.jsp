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

<div style="margin-left: 150px; margin-right: 150px" >
	
	<h2>My Purchases</h2>
	
	<div style="display: inline-flex; float: right;" >
		<form action="SeeProducts" method="post">
			<input type="submit" class="btn btn-info btn-lg" value="Continue Shopping">
		</form>

	</div>
	<br>
	<h5>${purchasemsg}</h5>
	<br>
		<table class="table table-striped" id="tb" border="1" cellpadding="10">
			<thead class="thead-dark">			
			<tr>
				<th>Item Name</th>
				<th>Quantity Purchased</th>
				<th>Total Price of this Item</th>
			</tr>
			</thead>
			
			<c:set var="finaltotal" value="${0}"/>
			<c:forEach items="${cartlist}" var="i">
				<tr>
					<td><c:out value="${i.itemname}" /></td>
					<td><c:out value="${i.itemquantity}" /></td>
					<td><c:out value="${i.totalprice}" /></td>	
					<c:set var="finaltotal" value="${finaltotal + i.totalprice}" />
									
				</tr>
				
			</c:forEach>
			
		</table>
		<br>
	<h4> Final Total : $ ${finaltotal} </h4><br>
	
	<h5>${finalbillmessage}</h5>
	<br>


</div>
</body>
</html>