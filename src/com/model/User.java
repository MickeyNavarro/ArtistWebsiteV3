//Almicke Navarro and Emily Quevedo
//CST-341
//September 16, 2019 
//This is our own work. 

//MODEL 
//this is the user object model; this page will hold the attributes, constructors, getters, and setters for a user

package com.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	//attributes
		//@NotNull is used to validate that the user inputs info 
	
	private int ID; //no need for not null as it will be incremented in the database
	
	@NotNull(message = "First name cannot be null.")
	@Size(min=3, max=30, message="First name must be between 3 and 30 characters.")
	private String firstName; 
	
	@NotNull(message = "Last name cannot be null.")
	@Size(min=3, max=30, message="Last name must be between 3 and 30 characters.")
	private String lastName;
	
	@NotNull(message = "Username cannot be null.")
	@Size(min=3, max=30, message="Username must be between 3 and 30 characters.")
	private String username; 
	
	@NotNull(message = "Email cannot be null.")
	@Pattern(regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}", message="Email must be valid.") 
	private String email; 
	
	@NotNull(message = "Phone Number cannot be null.")
	@Pattern(regexp="(^$|[0-9]{10})", message="Phone Number must consist of numbers.")
	@Size(min=10, max=10, message="Phone Number must be a valid length of 10 numbers.")
	private String phoneNumber; 
	
	@NotNull(message = "Password cannot be null.")
	@Size(min=3, max=30, message="Password must be between 3 and 30 characters.")
	private String password;
	
	private String role; 
		//if role = null, then the user would not be able to access admin functionalities
		//if role = ADMIN, then the user would be able to access admin functionalities
	
	
	//constructors 
	public User() {
		this.ID = 0;
		this.firstName = ""; 
		this.lastName = ""; 
		this.username = "";
		this.email = "";
		this.phoneNumber = "";
		this.password = "";
		this.role = null; 
	}

	public User(int iD,
				@NotNull(message = "First name cannot be null.") @Size(min = 3, max = 30, message = "First name must be between 3 and 30 characters.") String firstName,
				@NotNull(message = "Last name cannot be null.") @Size(min = 3, max = 30, message = "Last name must be between 3 and 30 characters.") String lastName,
				@NotNull(message = "Username cannot be null.") @Size(min = 3, max = 30, message = "Username must be between 3 and 30 characters.") String username,
				@NotNull(message = "Email cannot be null.") @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}", message = "Email must be valid.") String email,
				@NotNull(message = "Phone Number cannot be null.") @Size(min = 10, max = 10, message = "Phone Number must be a valid length of 10 characters.") String phoneNumber,
				@NotNull(message = "Password cannot be null.") @Size(min = 3, max = 30, message = "Password must be between 3 and 30 characters.") String password,
				String role) {
			super();
			ID = iD;
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = username;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.password = password;
			this.role = role;
		}



	//getters and setters 

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}