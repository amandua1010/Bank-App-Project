<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Update Customer</title>
</head>
<body>


	<h3>Updating the Customer here</h3>
	<br>

	<form:form action="addCustomer" modelAttribute="customer">

		<form:hidden path="customerId"/>

		<table>

			<tr>
				<td>Input Customer Name:</td>
				<td><form:input path="customerName" /></td>
			</tr>

			<tr>
				<td>Input Customer Phone:</td>
				<td><form:input path="customerPhone" /></td>
			</tr>

			<tr>
				<td>Input Customer Address:</td>
				<td><form:input path="customerAddress" />
			</tr>

			<tr>
				<td>Input Customer Email:</td>
				<td><form:input path="customerEmail" /></td>
			</tr>

<!--		<tr>
				<td>Input Customer Aadhar:</td>
				<td><form:input path="customerAadhar" /></td>
			</tr>

			<tr>
				<td>Input Customer PAN:</td>
				<td><form:input path="customerPAN" /></td>
			</tr>
-->	  

			<tr>
				<td><br>
				<input type="submit"></td>
			</tr>

		</table>

	</form:form>
	
	<br><br>
	<a href="/bankapp/home">Go To Home Page</a> <br>

</body>
</html>