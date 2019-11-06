<%--//Almicke Navarro and Emily Quevedo
	//CST-341
	//September 17, 2019 
	//This is our own work. 
	
	//VIEW 
	//this is the login page for the website; it will simply ask for the credentials of a returning user, send the credentials to the database for validation, & then lead to the home page once return validated--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
<style>
body {
	background-image: url('resources/ezgif.com-video-to-gif.gif');
	background-size: cover;
}
</style>
</head>
<body>
	<h2>Login</h2>
	<form:form method= "POST" modelAttribute="user" action="loginSuccess">
		<table> 
			<tr>
				<td><form:label path="username">Username:</form:label></td>
				<td><form:input path="username"/><form:errors path="username"/></td>
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
				<p>Don't have an account? Sign up <a href="register">here</a></p>
				</td>
		<form:errors path="*"/>
	</form:form>
</body>
</html>
