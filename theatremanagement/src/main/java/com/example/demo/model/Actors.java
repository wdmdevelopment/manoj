package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Actors {

	@Id
	@Column(name = "ID")
	private long id;

	@Column(name = "HERO")
	private String hero;

	@Column(name = "HEROINE")
	private String heroine;

	@Column(name = "DIRECTOR")
	private String director;

	@Column(name = "PRODUCER")
	private String producer;

	@Column(name = "MUSIC_DIRECTOR")
	private String musicDirector;

	@ManyToMany
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

}
