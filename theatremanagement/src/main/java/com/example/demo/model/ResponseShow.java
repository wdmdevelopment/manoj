package com.example.demo.model;

import java.util.List;

import com.example.demo.entity.Theatre;

public class ResponseShow {
	private long cinemaId;
	
	private String movieName;
	
	private Float rating;
	
	private String releasedYear;

	private String language;
	
	private String poster;
	
	private String description;
	
	private List<Theatre> theatres;

	
	public long getCinemaId() {
		return cinemaId;
	}

	
	public String getMovieName() {
		return movieName;
	}

	public Float getRating() {
		return rating;
	}

	
	public String getReleasedYear() {
		return releasedYear;
	}

	
	public String getLanguage() {
		return language;
	}

	
	public String getPoster() {
		return poster;
	}

	
	public List<Theatre> getTheatres() {
		return theatres;
	}


	public void setCinemaId(long cinemaId) {
		this.cinemaId = cinemaId;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public void setRating(Float rating) {
		this.rating = rating;
	}


	public void setReleasedYear(String releasedYear) {
		this.releasedYear = releasedYear;
	}

	
	public void setLanguage(String language) {
		this.language = language;
	}

	
	public void setPoster(String poster) {
		this.poster = poster;
	}


	public void setTheatres(List<Theatre> theatres) {
		this.theatres = theatres;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
}
