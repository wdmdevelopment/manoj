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
	
	private List<Theatre> theatres;

	/**
	 * @return the cinemaId
	 */
	public long getCinemaId() {
		return cinemaId;
	}

	/**
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}

	/**
	 * @return the rating
	 */
	public Float getRating() {
		return rating;
	}

	/**
	 * @return the releasedYear
	 */
	public String getReleasedYear() {
		return releasedYear;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @return the poster
	 */
	public String getPoster() {
		return poster;
	}

	/**
	 * @return the theatres
	 */
	public List<Theatre> getTheatres() {
		return theatres;
	}

	/**
	 * @param cinemaId the cinemaId to set
	 */
	public void setCinemaId(long cinemaId) {
		this.cinemaId = cinemaId;
	}

	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(Float rating) {
		this.rating = rating;
	}

	/**
	 * @param releasedYear the releasedYear to set
	 */
	public void setReleasedYear(String releasedYear) {
		this.releasedYear = releasedYear;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @param poster the poster to set
	 */
	public void setPoster(String poster) {
		this.poster = poster;
	}

	/**
	 * @param theatres the theatres to set
	 */
	public void setTheatres(List<Theatre> theatres) {
		this.theatres = theatres;
	}
}
