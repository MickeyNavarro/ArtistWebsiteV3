<script type="text/javascript">
	function getEvents() {
		//Make an AJAX call to Orders via REST service
		$.ajax(
		{
			type: "GET",
			url: "/ArtistWebsiteV3/service/events", dataType: "json", success: function(data) {
				$('#events').dataTable({
					"responsive":true,
					"data": data,
					"columns": [{"data": "name"}, {"data": "type"}, {"data": "location"}, {"data": "time"}, {"data": "date"}, {
		                "defaultContent": "<a href='https://web.livenation.com/'><button>Buy</button></a>"}] 
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

<div class="eventsPage">
	<h1>Our Events</h1>
	<table id="events" style="background-color: black" border="1" class="display">
		<thead>
			<tr  style="font-color: white">
				<th><label>Event Name</label></th>
				<th><label>Type</label></th>
				<th><label>Location</label></th>	
				<th><label>Time</label></th>
				<th><label>Date</label></th>
				<th><label>Tickets</label></th>
			</tr>		
		</thead>
		</table>
</div>
