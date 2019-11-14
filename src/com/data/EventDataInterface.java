//Almicke Navarro and Emily Quevedo
//CST-341
//November 7, 2019
//Event Data Interface class that will be implemented in the Event Data Service
package com.data;

import com.model.Event;

public interface EventDataInterface extends DataAccessInterface<Event> {
	/**
	 * Method to get an event in the database by its id
	 * @param id
	 * @return event
	 */
	public Event readById(int id); 
}
