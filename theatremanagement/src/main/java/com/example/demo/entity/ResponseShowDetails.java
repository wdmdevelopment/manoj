package com.example.demo.entity;

public class ResponseShowDetails {

	private ResponseTheatre theatrename;

	private ResponseCinema cinema;

	private String showTime;

	private String date;

	public ResponseTheatre getTheatrename() {
		return theatrename;
	}

	public void setTheatrename(ResponseTheatre theatrename) {
		this.theatrename = theatrename;
	}

	public ResponseCinema getCinema() {
		return cinema;
	}

	public void setCinema(ResponseCinema cinema) {
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
