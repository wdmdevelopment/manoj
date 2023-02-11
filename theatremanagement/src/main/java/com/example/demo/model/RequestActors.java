package com.example.demo.model;

import javax.validation.constraints.Size;

public class RequestActors {

	
	@Size(min = 2, max = 15)
	private String actor;
	
	@Size(min = 2, max = 15)
	private String actress;
	
	@Size(min = 2, max = 15)
	private String musicDirecter;
	
	@Size(min = 2, max = 15)
	private String Directer;
	
	private String releasedYear;
	
	public String getActor() {
		return actor;
	}

	
	public String getActress() {
		return actress;
	}

	
	public String getMusicDirecter() {
		return musicDirecter;
	}

	
	public String getDirecter() {
		return Directer;
	}

	
	public void setActor(String actor) {
		this.actor = actor;
	}


	public void setActress(String actress) {
		this.actress = actress;
	}

	
	public void setMusicDirecter(String musicDirecter) {
		this.musicDirecter = musicDirecter;
	}

	
	public void setDirecter(String directer) {
		Directer = directer;
	}


	public String getReleasedYear() {
		return releasedYear;
	}


	public void setReleasedYear(String releasedYear) {
		this.releasedYear = releasedYear;
	}

	
}
