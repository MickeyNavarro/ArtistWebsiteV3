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
	
	/*
	 * Create event mechanisms
	 */
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
		if (service.addEvent(event)) {
				
			//call the order business service to return a list of events
			List<Event> events = service.findAllEvents(); 
					
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
	
	/*
	 * Update event mechanisms
	 */
	@RequestMapping(path="/updateEvent", method = RequestMethod.GET) 
	public ModelAndView displayEventUpdatePage() { 
		return new ModelAndView("updateEventPage", "event", new Event(0,"","","","",""));
	}
			  
	@RequestMapping(path="/updateEventSuccess", method = RequestMethod.POST)
	public ModelAndView updateEvent(@Valid @ModelAttribute("event") Event event, BindingResult result) { 
		//validate the form 
		if(result.hasErrors()) { 
			//return to update event form to show any event update errors
			return new ModelAndView("updateEventPage", "event", event); 
		} 
				
		//call the order business service to update the event & check if successful
		if (service.editEvent(event)) {
				
			//call the order business service to return a list of events
			List<Event> events = service.findAllEvents(); 
					
			//return to the admin events page to show that event update was successful
				//no admin modules have been create yet so it will return to an temp. admin events page 
				return new ModelAndView("adminEventsPage", "events", events); 
		}
		else { 
			//if not, 
					
			//create a ModelAndView 
			ModelAndView mv = new ModelAndView("updateEventPage", "event", event); 
					
			//create new object to output that there was a database connection error
			mv.addObject("error", new String("Could not connect to database!")); 
					
			//return to create event form page to show the connection error
			return mv; 
		}
	}
	
	/*
	 * Delete event mechanisms
	 		  
	@RequestMapping(path="/deleteEvent", method = RequestMethod.POST)
	public ModelAndView deleteEvent(@Valid @ModelAttribute("event") int id, BindingResult result) { 
		//validate the form 
		if(result.hasErrors()) { 
			//return to update event form to show any event update errors
			return new ModelAndView("updateEventPage", "event", event); 
		} 
				
		//call the order business service to update the event & check if successful
		if (service.editEvent(event)) {
				
			//call the order business service to return a list of events
			List<Event> events = service.findAllEvents(); 
					
			//return to the admin events page to show that event update was successful
				//no admin modules have been create yet so it will return to an temp. admin events page 
				return new ModelAndView("adminEventsPage", "events", events); 
		}
		else { 
			//if not, 
					
			//create a ModelAndView 
			ModelAndView mv = new ModelAndView("updateEventPage", "event", event); 
					
			//create new object to output that there was a database connection error
			mv.addObject("error", new String("Could not connect to database!")); 
					
			//return to create event form page to show the connection error
			return mv; 
		}
	}
	*/

}
