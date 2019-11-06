//Almicke Navarro and Emily Quevedo
//CST-341
//October 11, 2019
//Event Interface class that will be implemented in the Event SpringBean
package com.business;

import java.util.List;

import com.model.Event;

public interface EventBusinessInterface {
	public List<Event> findAllEvents(); 
	public Event findEvent(int id); 
	public boolean addEvent(Event event); 
	public boolean editEvent(Event event); 
	public boolean deleteEvent(int id); 
}

