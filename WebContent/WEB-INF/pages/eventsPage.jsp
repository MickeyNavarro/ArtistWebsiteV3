<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	function getEvents() {
		//Make an AJAX call to Orders via REST service
		$.ajax(
		{
			type: "GET",
			url: "/WebsiteNew/service/events", dataType: "json", success: function(data) {
				$('#events').dataTable({
					"data": data,
					"columns": [{"data": "name"}, {"data": "type"}, {"data": "location"}, {"data": "time"}, {"data": "date"}, ]
				});
			},
		error: function(xhr, ajaxOptions, thrownError) 
			{
				alert(xhr.status);
				alert(thrownError);
			}
		});
	}
	$(document).ready(getEvents);
</script>

<style>
body {
	background-image: url('resources/stars.gif');
	padding: 150px;
}

.dataTables_wrapper .dataTables_length, .dataTables_wrapper .dataTables_filter, .dataTables_wrapper .dataTables_info, .dataTables_wrapper .dataTables_processing, .dataTables_wrapper .dataTables_paginate {
	color: white;
}

table.dataTable.display tbody tr.odd, table.dataTable.display tbody tr.odd>.sorting_1 {
	background-color: black;
}

.dataTables_wrapper .dataTables_paginate .paginate_button.disabled, .dataTables_wrapper .dataTables_paginate .paginate_button.disabled:hover, .dataTables_wrapper .dataTables_paginate .paginate_button.disabled:active {
    cursor: default;
    color: black !important;
    border: 1px solid transparent;
    background: transparent;
    box-shadow: none;
}

table.dataTable tbody tr, table.dataTable.display tbody tr.even>.sorting_1, table.dataTable.order-column.stripe tbody tr.even>.sorting_1, hover  {
	background-color: black;
}

</style>
<body>	
	<c:if test="${sessionScope.user.username == 'admin'}">
	<a href="adminEvents">Admin</a>
	</c:if>
	
	<table id="events" style="width:50%; background-color: black" border="1" class="display">
		<thead>
			<tr  style="font-color: white">
				<th><label>Event Name</label></th>
				<th><label>Type</label></th>
				<th><label>Location</label></th>	
				<th><label>Time</label></th>
				<th><label>Date</label></th>
			</tr>		
		</thead>
		</table>
</body>
