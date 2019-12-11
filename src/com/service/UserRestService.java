/**
 * Almicke Navarro and Emily Quevedo
 * CST-341
 * November 8, 2019 
 * This is our own work.
 * Rest Service
 */
package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.UserBusinessInterface;
import com.model.User;

@RestController
@RequestMapping("/service")
public class UserRestService {
		UserBusinessInterface service;
		
		/**
		 * Method to use the business service to get all the users from the database
		 * @return array of users
		 */
		@GetMapping("/users")
		public List<User> getUsers() {

			//List<User> users = service.findAllUsers();
			List<User> users = null; 
			//returns a list of users
			return users;
		}
		
		/**
		 * Method to set spring bean
		 * @param interface that the methods will refer to 
		 */
		@Autowired
		public void setUserService(UserBusinessInterface service) {
			this.service = service;
		}
}


