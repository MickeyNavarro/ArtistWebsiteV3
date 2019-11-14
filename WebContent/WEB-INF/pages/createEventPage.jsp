<%--//Almicke Navarro and Emily Quevedo
	//CST-341
	//October 11, 2019 
	//This is our own work. 
	
	//VIEW 
	//this is the create event page for the website; it will simply ask for the details of a new event, send the new event to the database for creation , & then lead to the event creation success page once the creation returns successful--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create Event</title>

<style>
body {
	background-image: url('resources/ezgif.com-video-to-gif.gif');
	background-size: cover;
	padding: 150px;
}
</style>
</head>
<body>
	<h2>Create Event</h2>
	<form:form method= "POST" modelAttribute="event" action="createEventSuccess">
		<table> 
			<tr>
				<td><form:label path="name">Event Name:</form:label></td>
				<td><form:input path="name"/><form:errors path="name"/></td>
			</tr>
			<tr>
				<td><form:label path="type">Type:</form:label></td>
				<td><form:input path="type"/><form:errors path="type"/></td>
			</tr>
			<tr>
				<td><form:label path="location">Location:</form:label></td>
				<td><form:input path="location"/><form:errors path="location"/></td>
			</tr>
			<tr>
				<td><form:label path="time">Time:</form:label></td>
				<td><form:input path="time"/><form:errors path="time"/></td>
			</tr>
			<tr>
				<td><form:label path="date">Date:</form:label></td>
				<td><form:input path="date"/><form:errors path="date"/></td>
			</tr>
			<tr>
				<td colspan="2"> 
					<input type = "submit" value = "Submit"/>
					<a href="events">Cancel</a>
				</td>
			</table>
	<font color="red"><p>${error}</p></font>
	</form:form>
</body>
</html>
