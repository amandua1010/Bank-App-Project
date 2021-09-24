<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Money Transfer</title>
</head>
<body>


	
	<h3>Money will be transfered from here</h3>
	<br>
	
	<form:form action="transferMoney" method="post" modelAttribute="transactionDto">
		<table>
			<tr>
				<td>Input the from Account Number</td>
				<td>
					<form:input path="fromAccountNumber" />
				 	<form:errors path="fromAccountNumber" class="error" />
				</td>
			</tr>
			<tr>
				<td>Input the to Account Number</td>
				<td>
					<form:input path="toAccountNumber" />
				 	<form:errors path="toAccountNumber" class="error" />
				</td>
			</tr>
			<tr>
				<td>Input the Transfer Amount you wish to transfer</td>
				<td>
					<form:input path="amount" />
				 	<form:errors path="amount" class="error" />
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