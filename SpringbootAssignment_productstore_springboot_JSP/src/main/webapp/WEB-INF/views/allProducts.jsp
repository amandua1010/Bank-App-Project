<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products Home Page</title>
</head>
<body>
	
	<h3>View all the Products here</h3>
	<br>
	
	<table border="1">
	
		<thead>
			<tr>
				<th> Product Id </th>
				<th> Product Name </th>
				<th> Product Price </th>
				<th> Product Discount </th>
				<th> Product Category </th>
				<th> Product Quantity </th>
				<th> Product Update </th>
				<th> Product Delete </th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
				
					<td> ${product.productId} </td>
					<td> ${product.productName} </td>
					<td> ${product.productPrice} </td>
					<td> ${product.productDiscount} </td>
					<td> ${product.productCategory} </td>
					<td> ${product.productQuantity} </td>
					
					<td><a href="updateProduct?id=<c:out value="${product.productId}"/>"> Update </a></td>
					
					<td><a href="deleteProduct?id=<c:out value="${product.productId}"/>"> Delete </a></td>
				
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
	<br>
	<a href="addProduct">Want to Add a new Product</a>

</body>
</html>