/**
 * Almicke Navarro and Emily Quevedo
 * CST-341
 * October 11, 2019
 * 
 * BUSINESS SERVICE 
 * this is the user business service; this will deal with any CRUD operations by sending the parameters to the data service 
 */

package com.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.data.UserDataInterface;
import com.model.User;

public class UserBusinessService implements UserBusinessInterface {
	@SuppressWarnings("rawtypes")
	@Autowired
	UserDataInterface dao;
	
	/**
	 * business method to ask the data service to create a user in the database
	 * @param new user with needed attributes
	 * @return true, if successful; false, if unsuccessful
	 */
	//create a new user
	@SuppressWarnings("unchecked")
	public boolean register(User user) {
		//returns if the user creation was successful
		return dao.create(user);
	}
	
	/**
	 * business method to ask the data service to find a user in the database
	 * @param returning user with matching username and password
	 * @return user
	 */
	//find user (used for login)
	@SuppressWarnings("unchecked")
	public User login(User user) {
		//return the user found 
		return (User)dao.read(user);
	}
	
	/**
	 * business method to ask the data service to edit a user in the database
	 * @param id of user to be edited
	 * @param user with the edited attributes
	 * @return true, if successful; false, if unsuccessful
	 */
	//update user info
	public boolean editUser(int id, User user) {
		return false;
	}
	
	/**
	 * business method to ask the data service to delete a user in the database
	 * @param id of user to be deleted
	 * @return true, if successful; false, if unsuccessful
	 */
	//delete user
	public boolean deleteUser(int id) {
		return false;
	}
}
