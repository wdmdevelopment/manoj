package com.example.demo.model;

import javax.validation.constraints.Size;

public class RequestActors {

	
	@Size(min = 4, max = 15)
	private String hero;
	
	@Size(min = 4, max = 15)
	private String heroine;
	
	@Size(min = 4, max = 15)
	private String director;
	
	@Size(min = 4, max = 15)
	private String producer;
	
	@Size(min = 4, max = 15)
	private String musicDirector;
	
	@Size(min = 4, max = 15)
	private String cinema;

	

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

	public String getCinema() {
		return cinema;
	}

	public void setCinema(String cinema) {
		this.cinema = cinema;
	}

}
