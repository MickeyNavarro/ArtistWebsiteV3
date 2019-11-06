<%--//Almicke Navarro and Emily Quevedo
	//CST-341
	//September 17, 2019 
	//This is our own work. 
	
	//VIEW 
	//this is the registration page for the website; it will simply ask for the credentials of a new user, send the new credentials to the database for creation , & then lead to the login page once the creation returns successful--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Register</title>
	<style>
body {
	background-image: url('resources/ezgif.com-video-to-gif.gif');
	background-size: cover;
	padding: 150px;
}
</style>
</head>
<body>
	<h2>Register</h2>
	<form:form method= "POST" modelAttribute="user" action="registerSuccess">
		<table> 
			<tr>
				<td><form:label path="firstName">First Name:</form:label></td>
				<td><form:input path="firstName"/><form:errors path="firstName"/></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name:</form:label></td>
				<td><form:input path="lastName"/><form:errors path="lastName"/></td>
			</tr>
			<tr>
				<td><form:label path="username">Username:</form:label></td>
				<td><form:input path="username"/><form:errors path="username"/></td>
			</tr>
			<tr>
				<td><form:label path="email">Email:</form:label></td>
				<td><form:input path="email"/><form:errors path="email"/></td>
			</tr>
			<tr>
				<td><form:label path="phoneNumber">Phone Number:</form:label></td>
				<td><form:input path="phoneNumber"/><form:errors path="phoneNumber"/></td>
			</tr>
			<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:password path="password"/><form:errors path="password"/></td>
			</tr>
			<tr>
				<td colspan="2"> 
					<input type = "submit" value = "Submit"/>
				</td>
			</table>
				<td>
				<p>Already have an account? Sign in <a href="login">here</a></p>
				</td>
		<font color= "red"><form:errors path="*"/></font>
	</form:form>
</body>
</html>