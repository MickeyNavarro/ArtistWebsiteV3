<%--//Almicke Navarro and Emily Quevedo
	//CST-341
	//November 3, 2019 
	//This is our own work. 
	
	//VIEW 
	//this is the update event page for the website; it will simply ask for the details of the updated event, send the new event to the database for update , & then lead to the event update success page if the update returns successful--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Update Event</title>

<style>
body {
	background-image: url('resources/ezgif.com-video-to-gif.gif');
	background-size: cover;
	padding: 150px;
}
</style>
</head>
<body>
	<h2>Update Event</h2>
	<form:form method= "POST" modelAttribute="event" action="updateEventSuccess">
		<table> 
			<tr>
				<td><form:label path="name">Event Name:</form:label></td>
				<td><form:input path="name" value = "${event.name}"/><form:errors path="name"/></td>
			</tr>
			<tr>
				<td><form:label path="type">Type:</form:label></td>
				<td><form:input path="type" value = "${event.type}"/><form:errors path="type"/></td>
			</tr>
			<tr>
				<td><form:label path="location">Location:</form:label></td>
				<td><form:input path="location" value = "${event.location}"/><form:errors path="location"/></td>
			</tr>
			<tr>
				<td><form:label path="time">Time:</form:label></td>
				<td><form:input path="time" value = "${event.time}"/><form:errors path="time"/></td>
			</tr>
			<tr>
				<td><form:label path="date">Date:</form:label></td>
				<td><form:input path="date" value = "${event.date}"/><form:errors path="date"/></td>
			</tr>
			<tr>
				<td colspan="2"> 
					<input type = "submit" value = "Submit"/>
				</td>
			</table>
	<font color="red"><p>${error}</p></font>
	</form:form>
</body>
</html>