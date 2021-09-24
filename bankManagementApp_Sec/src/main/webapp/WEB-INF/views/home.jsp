<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<style> <%@include file="/WEB-INF/views/css/style_home.css"%> </style>
<title>Home Page</title>
</head>
<body>
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="/bankapp/home">Bank App Home</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#main_nav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="main_nav">
				<ul class="navbar-nav">

					<li class="nav-item dropdown"><a
						class="nav-link  dropdown-toggle" href="#"
						data-bs-toggle="dropdown"> Manage Employees </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="user/showAllEmployees">
									Want to view all the Employees</a></li>
							<li><a class="dropdown-item" href="user/addEmployee">
									Want to Add an Employee </a></li>
						</ul></li>

					<li class="nav-item dropdown"><a
						class="nav-link  dropdown-toggle" href="#"
						data-bs-toggle="dropdown"> Manage Customers </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item"
								href="customer/showAllCustomers"> Want to view all the
									Customers</a></li>
							<li><a class="dropdown-item" href="customer/addCustomer">
									Want to Add a new Customer </a></li>
						</ul></li>

					<li class="nav-item dropdown"><a
						class="nav-link  dropdown-toggle" href="#"
						data-bs-toggle="dropdown"> Manage Transactions </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item"
								href="transaction/showAllTransactions"> Want to view all the
									Transactions</a></li>
							<li><a class="dropdown-item"
								href="transaction/pendingTransactio"> Want to view all the
									Pending Transactions </a></li>
						</ul></li>

					<li class="nav-item dropdown"><a
						class="nav-link  dropdown-toggle" href="#"
						data-bs-toggle="dropdown"> Want to do a Transaction </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item"
								href="transaction/withdrawMoney"> Want to Withdraw the Money
							</a></li>
							<li><a class="dropdown-item" href="transaction/depositMoney">Want
									to Deposit the Money </a></li>
							<li><a class="dropdown-item"
								href="transaction/transferMoney">Want to Transfer the Money
							</a></li>
						</ul></li>

					<li class="nav-item active"><a class="nav-link"
						href="/bankapp/logout">Logout </a></li>

				</ul>
			</div>
		</div>
	</nav>

	<br>
	<br>
	<br>
	<br>
	<br>
	
	<h5 class="demo">Featured Transaction Operations: </h5> <br>
	<div class="card" style="width: 18rem;">
		<div class="card-header">Featured Transaction Operations</div>
		<ul class="list-group list-group-flush">
			<li class="list-group-item"><a class="dropdown-item" href="transaction/withdrawMoney">Want to Withdraw the Money </a></li>
			<li class="list-group-item"><a class="dropdown-item" href="transaction/depositMoney">Want to Deposit the Money </a></li>
			<li class="list-group-item"><a class="dropdown-item" href="transaction/transferMoney">Want to Transfer the Money </a></li>
		</ul>
	</div>


	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

</body>
</html>