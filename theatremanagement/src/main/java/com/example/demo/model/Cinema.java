package com.example.demo.model;

import java.sql.Date;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity

@Table(name="CINEMA")

public class Cinema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@ManyToMany
	@JsonIgnore
	private List <ShowDetails> listOfShow;
	
	@Column	(name="MOVIE_NAME")																					
	private String movieName;
	
	@Column	(name="HERO")		
	private String hero;
	
	@Column	(name="HEROINE")
	private String heroine;
	
	@Column	(name="RATING")
	private Float rating;
	
	@Column	(name="RELEASED_YEAR")
	private String releasedYear;
	
	@Column	(name="LANGUAGE")
	private String language;
	
	@Column	(name="DIRECTOR")
	private String director;
	
	@Column	(name="PRODUCER")
	private String producer;
	
	@Column	(name="MUSIC_DIRECTOR")
	private String musicDirector;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<ShowDetails> getListOfShow() {
		return listOfShow;
	}

	public void setListOfShow(List<ShowDetails> listOfShow) {
		this.listOfShow = listOfShow;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getHero() {
		return hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}

	public String getHeroine() {
		return heroine;
	}

	public void setHeroine(String heroine) {
		this.heroine = heroine;
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
	
	
}
