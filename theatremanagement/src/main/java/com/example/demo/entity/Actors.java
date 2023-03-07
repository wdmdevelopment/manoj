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
	

	@Column(name = "name")
	
	private String actor;
	
	
	
	@Column(name = "role")
	private String actress;
	
	private String musicDirecter;
	
	//@Size(min = 2, max = 15)
	private String Directer;
	
	private String releasedYear;
	
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

	
	public String getActor() {
		return actor;
	}


	public String getActress() {
		return actress;
	}


	public String getMusicDirecter() {
		return musicDirecter;
	}

	
	public String getDirecter() {
		return Directer;
	}

	
	public void setActor(String actor) {
		this.actor = actor;
	}

	
	public void setActress(String actress) {
		this.actress = actress;
	}

	
	public void setMusicDirecter(String musicDirecter) {
		this.musicDirecter = musicDirecter;
	}

	
	public void setDirecter(String directer) {
		Directer = directer;
	}

	public String getReleasedYear() {
		return releasedYear;
	}

	public void setReleasedYear(String releasedYear) {
		this.releasedYear = releasedYear;
	}

	


	
	

}
