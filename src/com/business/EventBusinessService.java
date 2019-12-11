/**
 * Almicke Navarro and Emily Quevedo
 * CST-341
 * October 11, 2019
 * BUSINESS SERVICE 
 * this is the event business service; this will deal with any CRUD operations by sending the parameters to the data service
 */
package com.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.data.EventDataInterface;
import com.model.Event;

public class EventBusinessService implements EventBusinessInterface{
	@SuppressWarnings("rawtypes")
	@Autowired
	EventDataInterface dao; 

	/**
	 * business method to ask the data service to get all the events from the database
	 * @return arraylist of events
	 */
	@SuppressWarnings("unchecked")
	public List<Event> findAllEvents() {
		//returns all orders from the database
		return dao.readAll();
	}

	/**
	 * business method to ask the data service to find a single event from the database by its id 
	 * @param id of the event to be found
	 * @return event
	 */
	@Override
	public Event findEvent(int id) {
		//returns an event found in the database by its id
		return dao.readById(id);
	}

	/**
	 * business method to ask the data service to create an event in the database
	 * @param new event with needed attributes
	 * @return true, if successful; false, if unsuccessful
	 */
	@SuppressWarnings("unchecked")
	public boolean addEvent(Event event) {
		//returns if the event creation was successful
		return dao.create(event); 
	}

	/**
	 * business method to ask the data service to edit an event in the database
	 * @param event with edited attributes
	 * @return true, if successful; false, if unsuccessful
	 */
	@SuppressWarnings("unchecked")
	public boolean editEvent(Event event) {
		//returns if the event update was successful
		return dao.update(event);
	}

	/**
	 * business method to ask the data service to delete an event in the database
	 * @param id of event to be deleted
	 * @return true, if successful; false, if unsuccessful
	 */
	@SuppressWarnings("unchecked")
	public boolean deleteEvent(int id) {
		//returns if the event deletion was successful
		return dao.delete(id); 
	}
}
