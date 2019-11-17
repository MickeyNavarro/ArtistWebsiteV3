<%--//Almicke Navarro and Emily Quevedo
	//CST-341
	//October 11, 2019 
	//This is our own work. 
	
	//VIEW 
	//this is the admin events page for the website; it will simply ask for the display all of the events through the view of the admin; the admin user can access the CRUD operations of the events here 
	
	admin functionality has yet to be inputted so this page is available to all the users--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Events Page</title>
<style>
body {
	background-image: url('resources/stars.gif');
	padding: 150px;
}
</style>
</head>
<body>

<h2>Admin List of Events</h2>
		<c:if test="${sessionScope.user.username == 'admin'}">
		<a href="createEvent">Add Event</a>
		</c:if>
		
		<table> 
			<tr>
				<th><label>Event ID</label></th>
				<th><label>Event Name</label></th>
				<th><label>Type</label></th>
				<th><label>Location</label></th>	
				<th><label>Time</label></th>
				<th><label>Date</label></th>
			</tr>
		<c:forEach var = "event" items = "${events}">	
			<tr>
				<td><label>${event.ID}</label></td>
				<td><label>${event.name}</label></td>
				<td><label>${event.type}</label></td>
				<td><label>${event.location}</label></td>
				<td><label>${event.time}</label></td>
				<td><label>${event.date}</label></td>
				
				<c:if test="${sessionScope.user.username == 'admin'}">
				<td><form action = updateEvent method = 'POST'><input type = 'hidden' name = 'eventId' value = '${event.ID}'><input type = 'submit' value = 'Edit'></form> </td>
				<td><form action = deleteEvent method = 'POST'><input type = 'hidden' name = 'eventId' value = '${event.ID}'><input onclick="return confirm('Are you sure?');" type = 'submit' value = 'Delete'></form> </td>
				</c:if>
			</tr>
		</c:forEach>
		</table>
</body>
</html>
