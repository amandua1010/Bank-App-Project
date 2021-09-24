<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Update Employee</title>
</head>
<body>

	
	<h3>Updating the Employee here</h3>
	<br>
	
	<form:form action="addEmployee" method="post" modelAttribute="employee">
	<form:hidden path="userId"/>
		<table>
			<tr>
				<td>Input Username of the Employee</td>
				<td>
					<form:input path="username" />
				 	<form:errors path="username" class="error" />
				</td>
			</tr>
			
			<tr>
				<td>Input Email of the Employee</td>
				<td>
					<form:input path="email" />
					<form:errors path="email" class="error" />
				</td>
			</tr>
	
			<tr>
				<td>Input password of the Employee</td>
				<td>
					<form:input path="password" />
					<form:errors path="password" class="error" />
				</td>
			</tr>
	
			
			<tr>
				<td>Input Contact Number of the Employee</td>
				<td>
					<form:input path="phone" />
				 	<form:errors path="phone" class="error" />
				 </td>
			</tr>
			
			
			<tr>
				<td>Input Salary of the Employee</td>
				<td>
					<form:input type="number" path="salary"/>
					<form:errors path="salary" class="error" />
				 </td>
			</tr>
			
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
	
	<br><br>
	<a href="/bankapp/home">Go To Home Page</a> <br>

</body>
</html>