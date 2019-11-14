//Almicke Navarro and Emily Quevedo
//CST-341
//October 26, 2019
//Data Access Interface class that will be implemented in the other data interfaces

package com.data;

import java.util.List;

public interface DataAccessInterface<T> {
	/**
	 * Method to create a new object (T) in the database 
	 * @param t
	 * @return true, if successful; false, if unsuccessful
	 */
	public boolean create(T t); 
	
	/**
	 * Method to read a single object (T) in the database 
	 * @param t
	 * @return T
	 */
	public T read(T t); 
	
	/**
	 * Method to read all objects(T) in the database 
	 * @return list of objects (T)
	 */
	public List<T> readAll(); 
	
	/**
	 * Method to update an object(T) in the database 
	 * @param t
	 * @return true, if successful; false, if unsuccessful
	 */
	public boolean update(T t); 
	
	/**
	 * Method to delete an object(T) in the database 
	 * @param id 
	 * @return true, if successful; false, if unsuccessful
	 */
	public boolean delete(int id); 

}
