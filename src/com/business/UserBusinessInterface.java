/**
 * Almicke Navarro and Emily Quevedo
 * CST-341
 * October 11, 2019
 * User Interface class that will be implemented in the User SpringBean
 */

package com.business;

import com.model.User;

public interface UserBusinessInterface {
	/**
	 * Method to create(register) a user in the database
	 * @param new user with needed attributes
	 * @return true, if successful; false, if unsuccessful
	 */
	public boolean register(User user);
	
	/**
	 * Method to find(login) a user in the database
	 * @param returning user with matching username and password
	 * @return user
	 */
	public User login(User user);
	
	/**
	 * Method to edit a user in the database 
	 * @param id of user to be edited
	 * @param user with the edited attributes
	 * @return true, if successful; false, if unsuccessful
	 */
	public boolean editUser(int id, User user);
	
	/**
	 * Method to delete a user in the database
	 * @param id of user to be deleted
	 * @return true, if successful; false, if unsuccessful
	 */
	public boolean deleteUser(int id);
}
