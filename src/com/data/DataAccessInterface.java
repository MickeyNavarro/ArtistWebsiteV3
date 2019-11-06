//Almicke Navarro and Emily Quevedo
//CST-341
//October 26, 2019
//Data Access Interface class that will be implemented in the Data Service

package com.data;

import java.util.List;

public interface DataAccessInterface<T> {
	public boolean create(T t); 
	public T read(T t); 
	public List<T> readAll(); 
	public boolean update(T t); 
	public boolean delete(int id); 

}
