package com.example.demo.model;

import javax.validation.constraints.Size;

public class RequestActors {

	
	@Size(min = 2, max = 15)
	private String name;
	
	@Size(min = 2, max = 15)
	private String role;

	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
}
