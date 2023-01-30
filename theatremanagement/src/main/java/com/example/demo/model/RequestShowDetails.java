package com.example.demo.model;

import javax.validation.constraints.NotBlank;

public class RequestShowDetails {

	//private RequestTheatre theatrename;

	@NotBlank
	//private RequestCinema cinema;

	@NotBlank
	private String showTime;

	@NotBlank
	private String date;
	
	private long id;



	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
