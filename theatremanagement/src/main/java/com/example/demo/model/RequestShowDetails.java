package com.example.demo.model;

import javax.validation.constraints.NotBlank;

public class RequestShowDetails {

	private RequestTheatre theatrename;

	@NotBlank
	private RequestCinema cinema;

	@NotBlank
	private String showTime;

	@NotBlank
	private String date;

	public RequestTheatre getTheatrename() {
		return theatrename;
	}

	public void setTheatrename(RequestTheatre theatrename) {
		this.theatrename = theatrename;
	}

	public RequestCinema getCinema() {
		return cinema;
	}

	public void setCinema(RequestCinema cinema) {
		this.cinema = cinema;
	}

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

}
