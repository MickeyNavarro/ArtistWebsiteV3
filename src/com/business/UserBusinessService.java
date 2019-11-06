//Almicke Navarro and Emily Quevedo
//CST-341
//October 11, 2019
//User SpringBean 
package com.business;

import com.model.User;

public class UserBusinessService implements UserBusinessInterface {
	//temporary console output when logging in
	public void loginTest() {
		System.out.println("loginTest() in UserBusinessService");
	}
	//temporary console output when registering
	public void registerTest() {
		System.out.println("registerTest() in UserBusinessService");
	}
	//create a new user
	public boolean createUser(User user) {
		return false;
	}
	//find user by username (used for login)
	public User findByUsername(User user) {
		return user;
	}
	//update user info
	public boolean update(int id, User user) {
		return false;
	}
	//delete user
	public boolean delete(int id) {
		return false;
	}
}
