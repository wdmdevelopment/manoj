package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestCinema {

	// @NotBlank(message = "movieName is mandatory")
	@JsonProperty("movieName")
	private String movieName;

	private Float rating;

	// @NotBlank
	private String releasedYear;

	// @NotBlank
	private String language;

	private String poster;
		
	private long userid;
	

	
	private List<Long> actors;

	public RequestCinema() {
		super();
		
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

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}



	public List<Long> getActors() {
		return actors;
	}


	public void setActors(List<Long> actors) {
		this.actors = actors;
	}

	
}
