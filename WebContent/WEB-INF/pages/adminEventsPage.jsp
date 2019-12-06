<%--//Almicke Navarro and Emily Quevedo
	//CST-341
	//October 11, 2019 
	//This is our own work. 
	
	//VIEW 
	//this is the admin events page for the website; it will simply ask for the display all of the events through the view of the admin; the admin user can access the CRUD operations of the events here 
	
	admin functionality has yet to be inputted so this page is available to all the users--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Admin Events Page</title>

<div class="adminEvents">
<h2>Admin List of Events</h2>
		<c:if test="${sessionScope.user.username == 'admin'}">
		<a href="createEvent">Add Event</a>
		</c:if>

<div class="table-responsive">
<table class="table table-borderless table-dark" style="width:50%">
			<tr>
				<th><label>Event Name</label></th>
				<th><label>Type</label></th>
				<th><label>Location</label></th>	
				<th><label>Time</label></th>
				<th><label>Date</label></th>
				<th><label>Edit</label></th>
				<th><label>Delete</label></th>
			</tr>
		<c:forEach var = "event" items = "${events}">	
			<tr>
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
    </div>

		<c:forEach items="${errors}" var="error">
				<font color="red"><p>${error}</p></font>
			</c:forEach>
</div>
