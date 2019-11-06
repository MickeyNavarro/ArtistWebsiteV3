 //Almicke Navarro and Emily Quevedo
//CST-341
//October 11, 2019
//User Interface class that will be implemented in the User SpringBean
package com.business;

import com.model.User;

public interface UserBusinessInterface {
	//CRUD operations
	public boolean register(User user);
	public User login(User user);
	public boolean editUser(int id, User user);
	public boolean deleteUser(int id);
}
