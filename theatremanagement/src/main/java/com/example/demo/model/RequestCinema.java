package com.example.demo.model;

import javax.validation.constraints.NotBlank;

public class RequestCinema {
	
	@NotBlank(message = "movieName is mandatory")
	private String movieName;

	private Float rating;
	
	@NotBlank
	private String releasedYear;
	
	@NotBlank
	private String language;
	
	@NotBlank
	private String actors;

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

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

}
