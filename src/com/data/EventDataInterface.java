package com.data;

import com.model.Event;

public interface EventDataInterface extends DataAccessInterface<Event> {
	public Event readById(int id); 
}
