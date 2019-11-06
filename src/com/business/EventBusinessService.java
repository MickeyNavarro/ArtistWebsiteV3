//Almicke Navarro and Emily Quevedo
//CST-341
//October 11, 2019
//Event SpringBean 
package com.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.data.DataAccessInterface;
import com.model.Event;

public class EventBusinessService implements EventBusinessInterface{
	@SuppressWarnings("rawtypes")
	@Autowired
	DataAccessInterface dao; 

	@SuppressWarnings("unchecked")
	public List<Event> findAllEvents() {
		//returns all orders from the database
		return dao.readAll();
	}

	@Override
	public Event findEvent(int id) {
		// TODO Auto-generated method stub
		return null;
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
