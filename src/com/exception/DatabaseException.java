/**
 * Almicke Navarro and Emily Quevedo
 * CST-341
 * November 30, 2019 
 * This is our own work.
 * 
 * Custom database exception
 */

package com.exception;

public class DatabaseException extends RuntimeException{

	/**
	 * default serial version UID
	 */
	private static final long serialVersionUID = 8383092451958523986L;
	
	/**
	 * constructor to throw exception with stack trace
	 * @param e
	 */
	public DatabaseException(Throwable e) {
		//calls parent class constructor
		super(e); 
	}
}
