<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>

	<h3>Add the Product here</h3>
	<br>
	
	<form:form action="addProduct" modelAttribute="product">
	
	<form:hidden path="productId" value="0"/>
	
		<table>
		
			<tr>
				<td> Input Product Name: </td>
				<td><form:input path="productName" /></td>
			</tr>
			
			<tr>
				<td> Input Product Price: </td>
				<td><form:input path="productPrice" /></td>
			</tr>
			
			<tr>
				<td> Input Product Discount: </td>
				<td><form:input path="productDiscount" />
			</tr>
			
			<tr>
				<td> Input Product Category: </td>
				<td><form:input path="productCategory" /></td>
			</tr>
			
			<tr>
				<td> Input Product Quantity: </td>
				<td><form:input path="productQuantity" /></td>
			</tr>
			
			<tr>
				<td><br><input type="submit"></td>
			</tr>
			
		</table>
		
	</form:form>
	
</body>
</html>