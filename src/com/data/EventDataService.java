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


public class EventDataService implements EventDataInterface<Event>{
	
	@SuppressWarnings("unused")
	private DataSource dataSource; 
	private JdbcTemplate jdbcTemplateObject;
	
	/*
	 * Default constructor 
	 */
	public EventDataService() { 
	}
	
	@Override
	public List<Event> findAll() {
		String sql = "SELECT * FROM ArtistWeb.Event"; 
		List<Event> events = new ArrayList<Event>(); 
		
		try { 
			//output statement for console
			System.out.println("Successful connection!");
			
			//Execute SQL Query and loop over result set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql); 
			while(srs.next()) { 
				events.add(new Event(0, srs.getString("name"), 
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

	@Override
	public Event findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

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

	@Override
	public boolean update(Event event) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(Event event) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setDataSource(DataSource dataSource) { 
		this.dataSource = dataSource; 
		this.jdbcTemplateObject = new JdbcTemplate(dataSource); 
	}

}