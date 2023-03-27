package com.example.demo.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
public class RequestUser {

//	@NotBlank
//	private String fname;
//
//	@NotBlank
//	private String lname;
	private String userName;

	@Email
	private String email;

	@NotBlank(message = "New password is mandatory")
	@Size(min = 8, max = 20)
	private String password;

	@NotNull
	@Size(min = 10, max = 10)
	private String mobile;

	@NotNull
	private String role;

	
	public String getUserName() {
		return userName;
	}

	
	public String getEmail() {
		return email;
	}

	
	public String getPassword() {
		return password;
	}

	
	public String getMobile() {
		return mobile;
	}

	
	public String getRole() {
		return role;
	}

	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	
	

	
}
