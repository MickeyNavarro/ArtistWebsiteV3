//Almicke Navarro and Emily Quevedo
//CST-341
//October 26, 2019
//Event Data Interface class that will be implemented in the Event SpringBean

package com.data;

import java.util.List;

import com.model.Event;

public interface DataInterface<T> {
	public List<T> findAll(); 
	public Event findById(int id); 
	public boolean create(Event event); 
	public boolean update(Event event); 
	public boolean delete(Event event); 

}
