package com.example.demo.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
public class RequestUser {

	@NotBlank
	private String fname;

	@NotBlank
	private String lname;

	@Email
	private String email;

	@NotBlank(message = "New password is mandatory")
	private String pass;

	@NotBlank
	private String mobile;

	@NotBlank
	private String role;

	
	public String getFname() {
		return fname;
	}

	
	public void setFname(String fname) {
		this.fname = fname;
	}

	
	public String getLname() {
		return lname;
	}

	
	public void setLname(String lname) {
		this.lname = lname;
	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}

	
	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

	
}
