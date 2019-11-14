//Almicke Navarro and Emily Quevedo
//CST-341
//October 11, 2019
//Event Interface class that will be implemented in the Event SpringBean
package com.business;

import java.util.List;

import com.model.Event;

public interface EventBusinessInterface {
	/**
	 * Method to get the list of events from the database
	 * @return arraylist of events
	 */
	public List<Event> findAllEvents(); 
	
	/**
	 * Method to get an event from the database 
	 * @param id
	 * @return event
	 */
	public Event findEvent(int id); 
	
	/**
	 * Method to add a new event to the database
	 * @param event
	 * @return true, if successful; false, if unsuccessful
	 */
	public boolean addEvent(Event event); 
	
	/**
	 * Method to edit an event in the database
	 * @param event
	 * @return true, if successful; false, if unsuccessful
	 */
	public boolean editEvent(Event event); 
	
	/**
	 * Method to delete an event in the database
	 * @param id
	 * @return true, if successful; false, if unsuccessful
	 */
	public boolean deleteEvent(int id); 
}

