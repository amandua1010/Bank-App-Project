<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!--  <style><%@include file="/WEB-INF/views/css/style.css"%></style> -->
<title>Login Page</title>
</head>
<body>

	<h2>Welcome !!</h2>
	<h3>Login Page</h3>

	<br>
	<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION }">
		<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message }"></c:out>
	</c:if>

	<c:if test="${not empty param.logout}">
		<c:out value="Logged Out Successfully"></c:out>
	</c:if>
	<br> <br>
	
	<c:url value="/myloginprocessor" var="login" />
	<form:form action="${login}" method="post">
	
		<label>Username:</label> <input type="text" name=username /> <br> <br>
		
		<label>Password:</label> <input type="password" name="password" /> <br> <br>
		
		<input type="submit" />
	
	</form:form>

</body>
</html>