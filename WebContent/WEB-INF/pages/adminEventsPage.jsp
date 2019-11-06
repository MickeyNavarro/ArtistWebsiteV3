<%--//Almicke Navarro and Emily Quevedo
	//CST-341
	//October 11, 2019 
	//This is our own work. 
	
	//VIEW 
	//this is the admin events page for the website; it will simply ask for the display all of the events through the view of the admin; the admin user can access the CRUD operations of the events here 
	
	admin functionality has yet to be inputted so this page is available to all the users--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Admin Events Page</title>
<style>
body {
	background-image: url('resources/ezgif.com-video-to-gif.gif');
	background-size: cover;
}
</style>

</head>
<body>

<h1>Admin Events Page</h1>
<h2>List of Events</h2>
		<table> 
			<tr>
				<th><label>Event Name</label></th>
				<th><label>Type</label></th>
				<th><label>Location</label></th>	
				<th><label>Time</label></th>
				<th><label>Date</label></th>
			</tr>
		<c:forEach var = "event" items = "${events}">	
			<tr>
				<td><label>${event.name}</label></td>
				<td><label>${event.type}</label></td>
				<td><label>${event.location}</label></td>
				<td><label>${event.time}</label></td>
				<td><label>${event.date}</label></td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="2"> 
					<a href="createEvent">Create New Event</a>
				</td>
			</tr>
		</table>
</body>
</html>
