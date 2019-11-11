//Almicke Navarro and Emily Quevedo
//CST-341
//September 16, 2019 
//This is our own work.

//CONTROLLER 
//this is the user controller; this will deal with any CRUD operations for the model object of user
//https://dzone.com/articles/using-http-session-spring
package com.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
	/**
	 * This method will display the home page 
	 * @return homePage
	 */
		@RequestMapping(path="/home", method=RequestMethod.GET)
		public ModelAndView displayHomePage() { 
			return new ModelAndView("homePage", "user", new User(0,"","","","","","", 0));
			}
	/**
	 * This method will display the about page 
	 * @return aboutPage
	 */
		@RequestMapping(path="/about", method=RequestMethod.GET)
		public ModelAndView displayAboutPage() { 
			return new ModelAndView("aboutPage", "user", new User(0,"","","","","","", 0));
			}
	
	/**
	 * This method will display the registrationPage
	 * @return registrationPage
	 */
		@RequestMapping(path="/register", method = RequestMethod.GET) 
		public ModelAndView displayRegistrationPage() { 
			return new ModelAndView("registrationPage", "user", new User(0,"","","","","","", 0));
			}
	/**
	 * This method will carry out the user registration by sending the validated user to the business service
	 * @param user
	 * @param result
	 * @return loginPage, if the registration was successful; registrationPage with errors displayed, if unsuccessful
	 */
		@RequestMapping(path="/registerSuccess", method = RequestMethod.POST)
		public ModelAndView registerUser(@Valid @ModelAttribute("user") User user, BindingResult result) { 
			//Temporary 
			System.out.println("Entering UserController.registerUser()");
			//validate the form 
			if(!result.hasErrors()) { 
				
				//user is shown error message if login failed
				if (service.register(user)) {
					//return to the home page to show that login was successful
					return new ModelAndView("loginPage", "user", user); 
				}
			}
			//return to login form to show login errors
			return new ModelAndView("registrationPage", "user", user); 
		}
		
	/**
	 * This method will display the loginPage
	 * @return loginPage
	 */
		@RequestMapping(path="/login", method = RequestMethod.GET) 
		public ModelAndView displayLoginPage() { 
			return new ModelAndView("loginPage", "user", new User());
			}
		  
	/**
	 * This method will carry out the user login by sending the validated user to the business service & creating a session with the user object
	 * @param user
	 * @param result
	 * @param session
	 * @return homePage, if the registration was successful; loginPage with errors displayed, if unsuccessful
	 */
		@RequestMapping(path="/loginSuccess", method = RequestMethod.POST)
		public ModelAndView loginUser(@ModelAttribute("user") User user, BindingResult result, HttpSession session) { 
			//Temporary 
			System.out.println("Entering UserController.loginUser()");
			//validate the form 
			if(!result.hasErrors()) { 
				//user is shown error message if login failed
				if (service.login(user) == null) {
					ObjectError error = new ObjectError("*", "Invalid username or password");
					result.addError(error);
				}
				else {
					//set session
					session.setAttribute("user", user);
					//return to the home page to show that login was successful
					return new ModelAndView("homePage", "user", user); 
				}
			}
			//return to login form to show login errors
			return new ModelAndView("loginPage", "user", user); 
		}
		
	/**
	 * This method will carry out the user logout by destroying the session
	 * @param session
	 * @return homePage
	 */
		@RequestMapping(path="/logout", method = RequestMethod.GET) 
		public ModelAndView logout(HttpSession session) {
			//remove user attribute
			session.removeAttribute("user");
			//return to home page
			return new ModelAndView("homePage");
		}
}
