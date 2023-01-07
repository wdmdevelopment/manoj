package com.example.demo.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.NonNull;

public class RequestUser {

	 @NotEmpty
	 @NotNull
	private String user_fname;
	 @NotEmpty
	 @NotNull
	private String user_lname;

	 @NotNull
	 @NotEmpty
	 @Email
	private String user_email;

	
	 @NonNull
	 @NotBlank(message = "New password is mandatory")
	private String user_pass;

	 @NotNull
	 @NotEmpty
	private String user_mobile;
	

	public String getUser_fname() {
		return user_fname;
	}


	
	public void setUser_fname(String user_fname) {
		this.user_fname = user_fname;
	}


	
	public String getUser_lname() {
		return user_lname;
	}


	
	public void setUser_lname(String user_lname) {
		this.user_lname = user_lname;
	}


	
	public String getUser_email() {
		return user_email;
	}



	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	
	public String getUser_pass() {
		return user_pass;
	}


	
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}


	public String getUser_mobile() {
		return user_mobile;
	}


	
	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}


	

	
	
	

}
