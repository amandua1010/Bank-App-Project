<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Showing All Customers</title>
</head>
<body>


	<h3>Showing all the Customers here</h3>
	<br>
	
	<table border="1">
	
		<thead>
			<tr>
				<th> Customer Id </th>
				<th> Customer Name </th>
				<th> Customer Phone </th>
				<th> Customer Address </th>
				<th> Customer Email </th>
				<th> Customer Aadhar </th>
				<th> Customer PAN </th>
				<th> Customer Account Number </th>
				<th> Customer Account Balance </th>
				<th> Account PassBook </th>
				<th> Customer Update </th>
				<th> Customer Delete </th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${customers}" var="customer">
				<tr>
				
					<td> ${customer.customerId} </td>
					<td> ${customer.customerName} </td>
					<td> ${customer.customerPhone} </td>
					<td> ${customer.customerAddress} </td>
					<td> ${customer.customerEmail} </td>
					<td> ${customer.customerAadhar} </td>
					<td> ${customer.customerPAN} </td>
					<td> ${customer.account.accountId} </td>
					<td> ${customer.account.accountBalance} </td>
					
					<td><a href="/bankapp/transaction/accountPassbook?id=<c:out value="${customer.account.accountId}"/>"> Passbook </a></td>
					<td><a href="updateCustomer?id=<c:out value="${customer.customerId}"/>"> Update </a></td>
					<td><a href="deleteCustomer?id=<c:out value="${customer.customerId}"/>"> Delete </a></td>
				
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
	<br><br>
	
	<a href="addCustomer">Want to Add a new Customer</a> <br><br>
	
	<a href="/bankapp/home">Home Page</a> <br>
	

	
</body>
</html>