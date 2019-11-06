//Almicke Navarro and Emily Quevedo
//CST-341
//September 16, 2019 
//This is our own work.

//CONTROLLER 
//this is the user controller; this will deal with any CRUD operations for the model object of user
package com.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.business.UserBusinessInterface;
import com.model.User;

@Controller 
//@RequestMapping("/user")
public class UserController {
	//SpringBean declaration
	UserBusinessInterface service;
	
	public void setUserService(UserBusinessInterface service) {
		this.service = service;
	}
	//home page 
		@RequestMapping(path="/home", method=RequestMethod.GET)
		public ModelAndView displayHomePage() { 
			return new ModelAndView("homePage", "user", new User(0,"","","","","","",null));
			}
	
	//registration mechanisms
		@RequestMapping(path="/register", method = RequestMethod.GET) 
		public ModelAndView displayRegistrationPage() { 
			return new ModelAndView("registrationPage", "user", new User(0,"","","","","","",null));
			}
		  
		@RequestMapping(path="/registerSuccess", method = RequestMethod.POST)
		public ModelAndView registerUser(@Valid @ModelAttribute("user") User user, BindingResult result) { 
			//validate the form 
			if(result.hasErrors()) { 
				//return to registration form to show registration errors
				return new ModelAndView("registrationPage", "user", user); 
			}
			
			//Temporary until database is set up
			service.registerTest();
			
			//return to the login page to show that registration was successful
			return new ModelAndView("loginPage", "user", user); 
		}
		
	//login mechanisms
		@RequestMapping(path="/login", method = RequestMethod.GET) 
		public ModelAndView displayLoginPage() { 
			return new ModelAndView("loginPage", "user", new User(0,"","","","","","",null));
			}
		  
		@RequestMapping(path="/loginSuccess", method = RequestMethod.POST)
		public ModelAndView loginUser(@ModelAttribute("user") User user, BindingResult result) { 
			//validate the form 
			if(result.hasErrors()) { 
				//return to login form to show login errors
				return new ModelAndView("loginPage", "user", user); 
			}
			
			//Temporary until database is set up
			service.loginTest();
			
			//return to the home page to show that login was successful
			return new ModelAndView("homePage", "user", user); 
		}
	
	
}
