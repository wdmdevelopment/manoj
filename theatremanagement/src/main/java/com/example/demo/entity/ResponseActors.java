package com.example.demo.entity;

import java.util.List;

public class ResponseActors {

	private long id;

	private String hero;

	private String heroine;

	private String director;

	private String producer;

	private String musicDirector;

	private List<ResponseCinema> cinema;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<ResponseCinema> getCinema() {
		return cinema;
	}

	public void setCinema(List<ResponseCinema> cinema) {
		this.cinema = cinema;
	}

}
