//Almicke Navarro and Emily Quevedo
//CST-341
//October 11, 2019
//User SpringBean 
package com.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.data.UserDataInterface;
import com.model.User;

public class UserBusinessService implements UserBusinessInterface {
	@SuppressWarnings("rawtypes")
	@Autowired
	UserDataInterface dao;
	
	//create a new user
	@SuppressWarnings("unchecked")
	public boolean register(User user) {
		//returns if the user creation was successful
		return dao.create(user);
	}
	//find user (used for login)
	@SuppressWarnings("unchecked")
	public User login(User user) {
		//return the user found 
		return (User)dao.read(user);
	}
	//update user info
	public boolean editUser(int id, User user) {
		return false;
	}
	//delete user
	public boolean deleteUser(int id) {
		return false;
	}
}
