//Almicke Navarro and Emily Quevedo
//CST-341
//October 8, 2019 
//This is our own work. 

//MODEL 
//this is the event object model; this page will hold the attributes, constructors, getters, and setters for an event

//Resource: http://zetcode.com/java/hibernatevalidator/
package com.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Event {
	//attributes
			//all set to @NotNull to validate that the user inputs info 

	private int ID; //no need for not null as it will be incremented in the database

	@NotNull(message = "Name cannot be null.")
	@Size(min=3, max=45, message="Name must be between 3 and 45 characters.")
	private String name; 
	
	@NotNull(message = "Type cannot be null.")
	@Size(min=3, max=45, message="Type must be between 3 and 45 characters.")
	private String type; 
	
	@NotNull(message = "Location cannot be null.")
	@Size(min=3, max=45, message="Location must be between 3 and 45 characters.")
	private String location; 
	
	@NotNull(message = "Time cannot be null.")
	@NotEmpty(message = "Time cannot be empty.") //added due to no size constraint
	private String time; 
	
	@NotNull(message = "Date cannot be null.")
	@NotEmpty(message = "Date cannot be empty.") //added due to no size constraint
	private String date;

	public Event() {
		this.ID = 0; 
		this.name = "";
		this.type = "";
		this.location = "";
		this.time = "";
		this.date = "";
	}
	
	public Event(int iD,
			@NotNull(message = "Name cannot be null.") @Size(min = 3, max = 45, message = "Name must be between 3 and 45 characters.") String name,
			@NotNull(message = "Type cannot be null.") @Size(min = 3, max = 45, message = "Type must be between 3 and 45 characters.") String type,
			@NotNull(message = "Location cannot be null.") @Size(min = 3, max = 45, message = "Location must be between 3 and 45 characters.") String location,
			@NotNull(message = "Time cannot be null.") String time,
			@NotNull(message = "Date cannot be null.") String date) {
		super();
		ID = iD;
		this.name = name;
		this.type = type;
		this.location = location;
		this.time = time;
		this.date = date;
	}



	//getters and setters

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	

}
