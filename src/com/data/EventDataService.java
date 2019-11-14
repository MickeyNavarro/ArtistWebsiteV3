//Almicke Navarro and Emily Quevedo
//CST-341
//October 27, 2019 
//This is our own work.

//DATA SERVICE 
//this is the event data service; this will deal with any CRUD operations when interacting with the database
package com.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.model.Event;


public class EventDataService implements EventDataInterface{
	
	@SuppressWarnings("unused")
	private DataSource dataSource; 
	private JdbcTemplate jdbcTemplateObject;
	
	/*
	 * Default constructor 
	 */
	public EventDataService() { 
	}
	
	/**
	 * Method to create a new event in the database 
	 * @param event
	 * @return true, if successful; false, if unsuccessful
	 */
	@Override
	public boolean create(Event event) {
		String sql = "INSERT INTO ArtistWeb.Event (name, type, location, time, date) VALUES (?,?,?,?,?)";
		try { 
			//output statement for console
			System.out.println("Successful connection!");
			
			//Execute SQL Insert 
			int rows = jdbcTemplateObject.update(sql, 
					event.getName(), 
					event.getType(),
					event.getLocation(), 
					event.getTime(), 
					event.getDate()); 
			//Return result of Insert
			return rows == 1 ? true:false; 
		}
		catch (Exception e) { 
			//output statement for console
			System.out.println("Failed connection!");
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Method to read a single event in the database 
	 * @param event
	 * @return event
	 */
	@Override
	public Event read(Event event) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Method to read a single event in the database by its id
	 * @param id of an event
	 * @return event
	 */
	@Override
	public Event readById(int id) {
		String sql = "SELECT * FROM ArtistWeb.Event WHERE ID = ?"; 
		
		//initialize an event to be used to return with data later
		Event event = null; 
		
		try { 
			//output statement for console
			System.out.println("Successful connection!");
			
			//Execute SQL Query and check if an Event was returned
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, id); 
			if(srs.next()) { 
				event = new Event(id,
						srs.getString("name"), 
						srs.getString("type"), 
						srs.getString("location"), 
						srs.getString("time"), 
						srs.getString("date")); 

			}
			
		}
		catch (Exception e) { 
			//output statement for console
			System.out.println("Failed connection!");
			e.printStackTrace();
		}
		return event; 
	}
	
	/**
	 * Method to read all events in the database 
	 * @param n/a
	 * @return array of events
	 */
	@Override
	public List<Event> readAll() {
		String sql = "SELECT * FROM ArtistWeb.Event"; 
		
		//initialize a list of events to be used to return with data later
		List<Event> events = new ArrayList<Event>(); 
		
		try { 
			//output statement for console
			System.out.println("Successful connection!");
			
			//Execute SQL Query and loop over result set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql); 
			while(srs.next()) { 
				events.add(new Event(srs.getInt("ID"), 
						srs.getString("name"), 
						srs.getString("type"), 
						srs.getString("location"), 
						srs.getString("time"), 
						srs.getString("date"))); 

			}
			
		}
		catch (Exception e) { 
			//output statement for console
			System.out.println("Failed connection!");
			e.printStackTrace();
		}
		return events; 
	}

	/**
	 * Method to update an event in the database 
	 * @param event
	 * @return true, if successful; false, if unsuccessful
	 */
	@Override
	public boolean update(Event event) {
		String sql = "UPDATE ArtistWeb.Event SET name = ?, type =?, location = ?, time = ?, date = ? WHERE ID = ?";

		try { 
			//output statement for console
			System.out.println("Successful connection!");
			
			//Execute SQL update 
			int rows = jdbcTemplateObject.update(sql, 
					event.getName(), 
					event.getType(),
					event.getLocation(), 
					event.getTime(), 
					event.getDate(), 
					event.getID()); 
			
			//Return result of update
			return rows == 1 ? true:false; 
		}
		catch (Exception e) { 
			//output statement for console
			System.out.println("Failed connection!");
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Method to delete an event in the database 
	 * @param id of an event
	 * @return true, if successful; false, if unsuccessful
	 */
	@Override
	public boolean delete(int id) {
		String sql = "DELETE FROM ArtistWeb.Event WHERE ID = ?";
		
		try { 
			//output statement for console
			System.out.println("Successful connection!");
			
			//Execute SQL delete 
			int rows = jdbcTemplateObject.update(sql, id); 
			
			//Return result of delete
			return rows == 1 ? true:false; 
		}
		catch (Exception e) { 
			//output statement for console
			System.out.println("Failed connection!");
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Method to set the data source for use in the spring bean
	 * @param dataSource
	 * @return void
	 */
	public void setDataSource(DataSource dataSource) { 
		this.dataSource = dataSource; 
		this.jdbcTemplateObject = new JdbcTemplate(dataSource); 
	}

}