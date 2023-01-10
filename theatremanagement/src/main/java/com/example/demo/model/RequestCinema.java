package com.example.demo.model;

import javax.validation.constraints.NotBlank;

public class RequestCinema {
	
	//@NotBlank(message = "movieName is mandatory")
	private String movieName;

	private Float rating;
	
	//@NotBlank
	private String releasedYear;
	
	//@NotBlank
	private String language;
	
	//@NotBlank
	private String hero;
	//@NotBlank
	private String heroine;
	//@NotBlank
	private String director;
	//@NotBlank
	private String producer;
	//@NotBlank
	private String musicDirector;

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


	public String getHeroine() {
		return heroine;
	}

	public void setHeroine(String heroine) {
		this.heroine = heroine;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getMusicDirector() {
		return musicDirector;
	}

	public void setMusicDirector(String musicDirector) {
		this.musicDirector = musicDirector;
	}

	public String getHero() {
		return hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}

	

}
