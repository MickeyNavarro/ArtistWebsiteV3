//Almicke Navarro and Emily Quevedo
//CST-341
//October 11, 2019
//Event Interface class that will be implemented in the Event SpringBean
package com.business;

import java.util.List;

import com.model.Event;

public interface EventBusinessInterface {
	public List<Event> findAll(); 
	public Event findById(int id); 
	public boolean create(Event event); 
	public boolean update(Event event); 
	public boolean delete(Event event); 
}

