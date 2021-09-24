<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Showing All Employees</title>
</head>
<body>
	
	<h3>Showing all the Employees here</h3>
	<br>
	
	<table border="1">
	
		<thead>
			<tr>
				<th> Employee Id </th>
				<th> Employee Username </th>
				<th> Employee Email </th>
				<th> Employee Phone </th>
				<th> Employee Salary </th>
				<th> Employee Update </th>
				<th> Employee Delete </th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${employees}" var="employee">
				<tr>
				
					<td> ${employee.userId} </td>
					<td> ${employee.username} </td>
					<td> ${employee.email} </td>
					<td> ${employee.phone} </td>
					<td> ${employee.salary} </td>
				
					<td><a href="updateEmployee?id=<c:out value="${employee.userId}"/>"> Update </a></td>
					<td><a href="deleteEmployee?id=<c:out value="${employee.userId}"/>"> Delete </a></td>				
				
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
	<br><br>
	
	<a href="addEmployee">Want to Add a new Employee</a> <br><br>
	
	<a href="/bankapp/home">Go To Home Page</a> <br>

</body>
</html>