package com.example.demo.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Actors {

	@Id
	@Column(name = "ACTORS_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Size(min = 2, max = 15)
	@Column(name = "name")
	
	private String name;
	
	
	@Size(min = 2, max = 15)
	@Column(name = "role")
	private String role;
	
	
	
	@ManyToMany(mappedBy = "actors")
	@JsonIgnore
	private List<Cinema> cinema;

	public List<Cinema> getCinema() {
		return cinema;
	}

	public void setCinema(List<Cinema> cinema) {
		this.cinema = cinema;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
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
