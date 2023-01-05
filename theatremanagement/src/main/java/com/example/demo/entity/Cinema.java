package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CINEMA")

public class Cinema {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cinema_id")
	private long id;
	
	@Column(name = "MOVIE_NAME")
	private String movieName;
	
	@Column(name = "RATING")
	private Float rating;
	
	@Column(name = "RELEASED_YEAR")
	private String releasedYear;

	@Column(name = "LANGUAGE")
	private String language;

	@ManyToMany
	@JoinTable(name = "Actors_Cinema_Map", joinColumns = { @JoinColumn(name = "cinema_id") }, inverseJoinColumns = {
			@JoinColumn(name = "ACTORS_ID") })
	private List<Actors> actors;

	public List<Actors> getActors() {
		return actors;
	}

	public void setActors(List<Actors> actors) {
		this.actors = actors;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getReleasedYear() {
		return releasedYear;
	}

	public void setReleasedYear(String releasedYear) {
		this.releasedYear = releasedYear;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
