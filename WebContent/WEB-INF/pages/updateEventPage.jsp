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
	background-image: url('resources/stars.gif');
	padding: 150px;
}
</style>

 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$( function() {
    $( "#datepicker" ).datepicker();
  } );
</script>
</head>
<body>
	<h2>Update Event</h2>
	<form:form method= "POST" modelAttribute="event" action="updateEventSuccess">
		<form:hidden name="ID" value="${event.ID}" path="ID"/>
		<table> 
			<tr>
				<td><form:label path="name">Event Name:</form:label></td>
				<td><form:input placeholder="Enter Event Name" path="name" value="${event.name}"/><form:errors path="name"/></td>
			</tr>
			<tr>
				<td><form:label path="type">Type:</form:label></td>
				<td><form:select path="type" id="type" name="type">
				<option disabled selected value="${event.type}">${event.type}</option>
					<option value="Concert Tour">Concert Tour</option>
					<option value="Album Release">Album Release</option>
					<option value="Meet and Greet">Meet and Greet</option>
				</form:select></td>
			</tr>
			<tr>
				<td><form:label path="location">Location:</form:label></td>
				<td><form:input placeholder="Enter Location" path="location" value = "${event.location}"/><form:errors path="location"/></td>
			</tr>
			<tr>
				<td><form:label path="time">Time:</form:label></td>
				<td><form:select placeholder="Enter Time" path="time" id="time" name="time">
				<option disabled selected value="${event.time}">${event.time}</option>
					<option value="12 AM">12 AM</option>
					<option value="12:30 AM">12:30 AM</option>
					<option value="1 AM">1 AM</option>
					<option value="1:30 AM">1:30 AM</option>
					<option value="2 AM">2 AM</option>
					<option value="2:30 AM">2:30 AM</option>
					<option value="3 AM">3 AM</option>
					<option value="3:30 AM">3:30 AM</option>
					<option value="4 AM">4 AM</option>
					<option value="4:30 AM">4:30 AM</option>
					<option value="5 AM">5 AM</option>
					<option value="5:30 AM">5:30 AM</option>
					<option value="6 AM">6 AM</option>
					<option value="6:30 AM">6:30 AM</option>
					<option value="7 AM">7 AM</option>
					<option value="7:30 AM">7:30 AM</option>
					<option value="8 AM">8 AM</option>
					<option value="8:30 AM">8:30 AM</option>
					<option value="9 AM">9 AM</option>
					<option value="9:30 AM">9:30 AM</option>
					<option value="10 AM">10 AM</option>
					<option value="10:30 AM">10:30 AM</option>
					<option value="11 AM">11 AM</option>
					<option value="11:30 AM">11:30 AM</option>
					<option value="12 PM">12 PM</option>
					<option value="12:30 PM">12:30 PM</option>
					<option value="1 PM">1 PM</option>
					<option value="1:30 PM">1:30 PM</option>
					<option value="2 PM">2 PM</option>
					<option value="2:30 PM">2:30 PM</option>
					<option value="3 PM">3 PM</option>
					<option value="3:30 PM">3:30 PM</option>
					<option value="4 PM">4 PM</option>
					<option value="4:30 PM">4:30 PM</option>
					<option value="5 PM">5 PM</option>
					<option value="5:30 PM">5:30 PM</option>
					<option value="6 PM">6 PM</option>
					<option value="6:30 PM">6:30 PM</option>
					<option value="7 PM">7 PM</option>
					<option value="7:30 PM">7:30 PM</option>
					<option value="8 PM">8 PM</option>
					<option value="8:30 PM">8:30 PM</option>
					<option value="9 PM">9 PM</option>
					<option value="9:30 PM">9:30 PM</option>
					<option value="10 PM">10 PM</option>
					<option value="10:30 PM">10:30 PM</option>
					<option value="11 PM">11 PM</option>
					<option value="11:30 PM">11:30 PM</option>
				</form:select></td>
			</tr>
			<tr>
				<td><form:label path="date">Date:</form:label></td>
				<td><form:input placeholder="Enter Date" id="datepicker" value="${event.date}" path="date"/><form:errors path="date"/></td>
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
