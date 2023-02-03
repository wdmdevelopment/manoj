package com.example.demo.model;


import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RequestShowDetails {


	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private String showTime;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@Column(name = "DATE")
	private String date;
	
	private long cinemaId;
	
	private long theatreId;
	
	
	
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

	

	public RequestShowDetails(@NotNull String showTime, @NotNull String date, long cinemaId, long theatreId) {
		super();
		this.showTime = showTime;
		this.date = date;
		this.cinemaId = cinemaId;
		this.theatreId = theatreId;
	}


	public long getTheatreId() {
		return theatreId;
	}


	public void setTheatreId(long theatreId) {
		this.theatreId = theatreId;
	}


	public long getCinemaId() {
		return cinemaId;
	}


	public void setCinemaId(long cinemaId) {
		this.cinemaId = cinemaId;
	}

	
	
	
	
	
}
