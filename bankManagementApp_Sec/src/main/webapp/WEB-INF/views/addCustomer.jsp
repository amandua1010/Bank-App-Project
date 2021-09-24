<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>

<style>
	.error{
		color:red;
	}
</style>

</head>
<body>

	<h3>Adding the Customer here</h3>
	<br>
	
	<form:form action="addCustomer" modelAttribute="customer">
	
	<form:hidden path="customerId" value="0"/>
	
		<table>
		
			<tr>
				<td> Input Customer Name: </td>
				<td><form:input path="customerName" />
					<form:errors path="customerName" class="error" />
				</td>
			</tr>
			
			<tr>
				<td> Input Customer Phone: </td>
				<td><form:input path="customerPhone" />
					<form:errors path="customerPhone" class="error" />
				</td>
			</tr>
			
			<tr>
				<td> Input Customer Address: </td>
				<td><form:input path="customerAddress" />
					<form:errors path="customerAddress" class="error" />
				</td>
			</tr>
			
			<tr>
				<td> Input Customer Email: </td>
				<td><form:input path="customerEmail" />
					<form:errors path="customerEmail" class="error" />
				</td>
			</tr>
			
			<tr>
				<td> Input Customer Aadhar: </td>
				<td><form:input path="customerAadhar" />
					<form:errors path="customerAadhar" class="error" />
				</td>
			</tr>
			
			<tr>
				<td> Input Customer PAN: </td>
				<td><form:input path="customerPAN" />
					<form:errors path="customerPAN" class="error" />
				</td>
			</tr>
			
			<tr>
				<td> Input Customer Balance: </td>
				<td><input type="number" name="accountBalance"/></td>
			</tr>
			
			<tr>
				<td><br><input type="submit"></td>
			</tr>
			
		</table>
		
	</form:form>
	
	<br><br>
	<a href="/bankapp/home">Go To Home Page</a> <br>
	

</body>
</html>