/**
 * Almicke Navarro and Emily Quevedo
 * CST-341
 * October 11, 2019 This is our own work.
 *  
 * CONTROLLER 
 * this is the event controller; this will deal with any CRUD operations for the model object of event
 */
package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.business.EventBusinessInterface;
import com.model.Event;

@Controller 
//@RequestMapping("/event")
public class EventController {
	//SpringBean declaration
	EventBusinessInterface service;
	
	/**
	 * Method to set the bean 
	 * @param service
	 */
	public void setEventService(EventBusinessInterface service) {
		this.service = service;
	}
	
	/**
	 * This method will display the events page
	 * @return eventsPage 
	 */
	@RequestMapping(path="/events", method=RequestMethod.GET)
	public ModelAndView displayEvents() { 
		try {
			//call the order business service to return a list of events
			List<Event> events = service.findAllEvents(); 
			return new ModelAndView("eventsPage", "events", events);
		}
		//make sure to catch all exceptions 
		catch (Exception e) {
			//create a ModelAndView 
			ModelAndView mv = new ModelAndView("errorPage"); 
					
			//create a string message for the errorPage 
			String err = "ERROR: " + e.getMessage();
					
			//create new object to output the error
			mv.addObject("error", err); 
					
			//return to create event form page to show the connection error
			return mv; 
		}
	}
	
	/**
	 * This method will display the admin events page
	 * @return adminEventsPage 
	 */
	@RequestMapping(path="/adminEvents", method=RequestMethod.GET)
	public ModelAndView displayAdminEvents() { 
		try {
			//call the order business service to return a list of events
			List<Event> events = service.findAllEvents(); 
			return new ModelAndView("adminEventsPage", "events", events);
		}
		catch (Exception e) { 
			//create a ModelAndView 
			ModelAndView mv = new ModelAndView("errorPage"); 
					
			//create a string message for the errorPage 
			String err = "ERROR: " + e.getMessage();
					
			//create new object to output the error
			mv.addObject("error", err); 
					
			//return to create event form page to show the connection error
			return mv; 
		}
	}
	
	/**
	 * This method will display the createEventPage
	 * @return createEventPage 
	 */
	@RequestMapping(path="/createEvent", method = RequestMethod.GET) 
	public ModelAndView displayEventCreationPage() { 
		return new ModelAndView("createEventPage", "event", new Event(0,"","","","",""));
	}
		
	/**
	 * This method will carry out the event creation by sending the validated event to the business service
	 * @param event
	 * @param result
	 * @return adminEventsPage, if the creation was successful; createEventPage with errors displayed, if unsuccessful
	 */
	@RequestMapping(path="/createEventSuccess", method = RequestMethod.POST)
	public ModelAndView createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result) { 
		//validate the form 
		if(result.hasErrors()) { 
			//return to create event form to show any event creation errors
			return new ModelAndView("createEventPage", "event", event); 
		} 
		
		try {
			//call the order business service to create the event & check if successful
			service.addEvent(event); 
				
			//call the order business service to return a list of events
			List<Event> events = service.findAllEvents(); 
					
			//return to the admin events page to show that event creation was successful
				//no admin modules have been create yet so it will return to an temp. admin events page 
				return new ModelAndView("adminEventsPage", "events", events); 
		}
		catch (Exception e) { 					
			//create a ModelAndView 
			ModelAndView mv = new ModelAndView("createEventPage", "event", event); 
					
			//create a string message for the errorPage 
			String err = "ERROR: " + e.getMessage();
					
			//create new object to output the error
			mv.addObject("error", err);  
					
			//return to create event form page to show the connection error
			return mv; 
		}
	}
	
	/**
	 * This method will display the updateEventPage
	 * @param id of event
	 * @return updateEventPage, if the connection was successful; errorPage with errors displayed, if unsuccessful
	 */
	@RequestMapping(path="/updateEvent", method = RequestMethod.POST) 
	public ModelAndView displayEventUpdatePage(@RequestParam(name= "eventId") int id) { 
		
		//check if an id was passed
		if (id != 0) { 
			
			try {
				//call the order business service to find the event by its given id 
				Event event = service.findEvent(id); 
				
				return new ModelAndView("updateEventPage", "event", event);
			}
			catch (Exception e) {
				//create a ModelAndView 
				ModelAndView mv = new ModelAndView("errorPage"); 
						
				//create a string message for the errorPage 
				String err = "ERROR: " + e.getMessage();
						
				//create new object to output the error
				mv.addObject("error", err);  
						
				//return to create event form page to show the connection error
				return mv; 
			}

		}
		else {		
			//create a ModelAndView 
			ModelAndView mv = new ModelAndView("errorPage"); 
					
			//create new object to output the error
			mv.addObject("error", new String("There was an error with finding that event!")); 
					
			//return to create event form page to show the connection error
			return mv; 
			
		}

	}
	
	/**
	 * This method will carry out the event update  by sending the validated event to the business service
	 * @param event
	 * @param result
	 * @return adminEventsPage, if the update was successful; updateEventPage with errors displayed, if unsuccessful
	 */
	@RequestMapping(path="/updateEventSuccess", method = RequestMethod.POST)
	public ModelAndView updateEvent(@Valid @ModelAttribute("event") Event event, BindingResult result) { 

		//validate the form 
		if(result.hasErrors()) { 
			//return to update event form to show any event update errors
			return new ModelAndView("updateEventPage", "event", event); 
		} 

		try {
			//call the order business service to update the event & check if successful
			service.editEvent(event); 
				
			//call the order business service to return a list of events
			List<Event> events = service.findAllEvents(); 
					
			//return to the admin events page to show that event update was successful
				//no admin modules have been create yet so it will return to an temp. admin events page 
				return new ModelAndView("adminEventsPage", "events", events); 
		}
		catch (Exception e) { 					
			//create a ModelAndView 
			ModelAndView mv = new ModelAndView("updateEventPage", "event", event); 
					
			//create a string message for the errorPage 
			String err = "ERROR: " + e.getMessage();
					
			//create new object to output the error
			mv.addObject("error", err);  
					
			//return to create event form page to show the connection error
			return mv; 
		}
	}
	
	/**
	 * This method will carry out the event deletion by sending the event id to the business service	  
	 * @param id
	 * @return adminEventsPage, if the deletion was successful; errorPage with errors displayed, if unsuccessful
	 */
	@RequestMapping(path="/deleteEvent", method = RequestMethod.POST)
	public ModelAndView deleteEvent(@RequestParam(name= "eventId") int id) { 
		try {
			//call the order business service to update the event & check if successful
			service.deleteEvent(id); 
				
			//call the order business service to return a list of events
			List<Event> events = service.findAllEvents(); 
					
			//return to the admin events page to show that event update was successful
				//no admin modules have been create yet so it will return to an temp. admin events page 
				return new ModelAndView("adminEventsPage", "events", events); 
		}
		catch (Exception e) {
			//create a ModelAndView 
			ModelAndView mv = new ModelAndView("errorPage"); 
					
			//create a string message for the errorPage 
			String err = "ERROR: " + e.getMessage();
					
			//create new object to output the error
			mv.addObject("error", err); 
					
			//return to create event form page to show the connection error
			return mv; 
		}
	}
}
