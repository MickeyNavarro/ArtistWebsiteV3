//Almicke Navarro and Emily Quevedo
//CST-341
//December 3, 2019 
//This is our own work.

//CONTROLLER 
//this is the home controller; this will deal with home page

package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class HomeController {
	/**
	 * This method will display the home page 
	 * @return homePage
	 */
		@RequestMapping(path="/home", method=RequestMethod.GET)
		public ModelAndView displayHomePage() { 
			return new ModelAndView("homePage");
		}
}
