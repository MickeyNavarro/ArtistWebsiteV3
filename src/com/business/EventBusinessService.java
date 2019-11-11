//Almicke Navarro and Emily Quevedo
//CST-341
//October 11, 2019
//BUSINESS SERVICE 
//this is the event business service; this will deal with any CRUD operations by sending the parameters to the data service
package com.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.data.EventDataInterface;
import com.model.Event;

public class EventBusinessService implements EventBusinessInterface{
	@SuppressWarnings("rawtypes")
	@Autowired
	EventDataInterface dao; 

	@SuppressWarnings("unchecked")
	public List<Event> findAllEvents() {
		//returns all orders from the database
		return dao.readAll();
	}

	@Override
	public Event findEvent(int id) {
		//returns an event found in the database by its id
		return dao.readById(id);
	}

	@SuppressWarnings("unchecked")
	public boolean addEvent(Event event) {
		//returns if the event creation was successful
		return dao.create(event); 
	}

	@SuppressWarnings("unchecked")
	public boolean editEvent(Event event) {
		//returns if the event update was successful
		return dao.update(event);
	}

	@SuppressWarnings("unchecked")
	public boolean deleteEvent(int id) {
		//returns if the event deletion was successful
		return dao.delete(id); 
	}
}
