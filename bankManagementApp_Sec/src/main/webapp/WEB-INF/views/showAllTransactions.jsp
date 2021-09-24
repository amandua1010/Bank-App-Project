<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Showing All Transactions</title>
</head>
<body>
	
	<h3>Showing all the Transactions here</h3>
	<br>

	<table border="1">

		<thead>
			<tr>
				<th>Transaction Id</th>
				<th>Transaction from Account Number</th>
				<th>Transaction to Account Number</th>
				<th>Transaction Amount</th>
				<th>Transaction Type</th>
				<th>Transaction Status</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${transactions}" var="transaction">
				<tr>

					<td>${transaction.transactionId}</td>

					<td>
						<c:if test="${transaction.fromAccountNumber == null}"> From Self Account </c:if>
						<c:if test="${transaction.fromAccountNumber != null}"> ${transaction.fromAccountNumber} </c:if>
					</td>

					<td>
						<c:if test="${transaction.toAccountNumber == null}"> To Self Account </c:if>
						<c:if test="${transaction.toAccountNumber != null}"> ${transaction.toAccountNumber} </c:if>
					</td>

					<td>${transaction.amount}</td>

					<td>${transaction.transactionType}</td>

					<td>${transaction.status}</td>

				</tr>
			</c:forEach>
		</tbody>

	</table>
	<br><br>

	<a href="depositMoney">Want to Deposit Money</a> <br><br>

	<a href="withdrawMoney">Want to Withdraw Money</a> <br><br>

	<a href="transferMoney">Want to do a Transaction</a> <br><br>

	<a href="/bankapp/home">Home Page</a> <br><br>

</body>
</html>