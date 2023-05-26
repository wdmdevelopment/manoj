package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RequestLogin {
	
	@NotBlank(message = "useName Is must")
	private String username;
	
	@NotBlank(message = "password Is must")
	private String password;

	
	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
