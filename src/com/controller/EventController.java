//Almicke Navarro and Emily Quevedo
//CST-341
//October 11, 2019 
//This is our own work.

//CONTROLLER 
//this is the event controller; this will deal with any CRUD operations for the model object of event
package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.business.EventBusinessInterface;
import com.model.Event;

@Controller 
//@RequestMapping("/event")
public class EventController {
	//SpringBean declaration
	EventBusinessInterface service;
	
	public void setEventService(EventBusinessInterface service) {
		this.service = service;
	}
	//create an event mechanisms
			@RequestMapping(path="/createEvent", method = RequestMethod.GET) 
			public ModelAndView displayEventCreationPage() { 
				return new ModelAndView("createEventPage", "event", new Event(0,"","","","",""));
				}
			  
			@RequestMapping(path="/createEventSuccess", method = RequestMethod.POST)
			public ModelAndView createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result) { 
				//validate the form 
				if(result.hasErrors()) { 
					//return to create event form to show any event creation errors
					return new ModelAndView("createEventPage", "event", event); 
				} 
				
				//call the order business service to create the event & check if successful
				if (service.create(event)) {
				
					//call the order business service to return a list of events
					List<Event> events = service.findAll(); 
					
					//return to the admin events page to show that event creation was successful
						//no admin modules have been create yet so it will return to an temp. admin events page 
					return new ModelAndView("adminEventsPage", "events", events); 
				}
				else { 
					//if not, 
					
					//create a ModelAndView 
					ModelAndView mv = new ModelAndView("createEventPage", "event", event); 
					
					//create new object to output that there was a database connection error
					mv.addObject("error", new String("Could not connect to database!")); 
					
					//return to create event form page to show the connection error
					return mv; 
				}
			}

}
