/**
 * Almicke Navarro and Emily Quevedo
 * CST-341
 * October 26, 2019
 * Data Access Interface class that will be implemented in the other data interfaces
 */

package com.data;

import java.util.List;

public interface DataAccessInterface<T> {
	/**
	 * Method to create a new object (T) in the database 
	 * @param new object with needed attributes to be created
	 * @return true, if successful; false, if unsuccessful
	 */
	public boolean create(T t); 
	
	/**
	 * Method to read a single object (T) in the database 
	 * @param object or attribute of the object to allow to be found
	 * @return object found
	 */
	public T read(T t); 
	
	/**
	 * Method to read all objects(T) in the database 
	 * @return list of objects (T)
	 */
	public List<T> readAll(); 
	
	/**
	 * Method to update an object(T) in the database 
	 * @param object with edited attributes 
	 * @return true, if successful; false, if unsuccessful
	 */
	public boolean update(T t); 
	
	/**
	 * Method to delete an object(T) in the database 
	 * @param id of object to be deleted
	 * @return true, if successful; false, if unsuccessful
	 */
	public boolean delete(int id); 

}
