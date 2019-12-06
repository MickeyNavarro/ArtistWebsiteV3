<%--//Almicke Navarro and Emily Quevedo
	//CST-341
	//September 17, 2019 
	//This is our own work. 
	
	//VIEW 
	//this is the login page for the website; it will simply ask for the credentials of a returning user, send the credentials to the database for validation, & then lead to the home page once return validated--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>

<title>Login</title>

<div class="login">
	<h2>Login</h2>
	<form:form method= "POST" modelAttribute="user" action="loginSuccess">
		<table> 
			<tr>
				<td><form:label path="username">Username:</form:label></td>
				<td><form:input placeholder="Enter Username" path="username"/></td>
			</tr>
			<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:password placeholder="Enter Password" path="password"/></td>
			</tr>
			<tr>
				<td colspan="2"> 
					<input type = "submit" value = "Submit"/>
				</td>
			</table>
							<td>
				<p>Don't have an account? Sign up <a href="register">here</a></p>
				</td>
		<font color="red"><form:errors path="*"/></font>
	</form:form>
</div>
