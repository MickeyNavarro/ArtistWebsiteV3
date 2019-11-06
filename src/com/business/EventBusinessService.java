//Almicke Navarro and Emily Quevedo
//CST-341
//October 11, 2019
//Event SpringBean 
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
	public List<Event> findAll() {
		//returns all orders from the database
		return dao.findAll();
	}

	@Override
	public Event findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public boolean create(Event event) {
		return dao.create(event); 
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
}
