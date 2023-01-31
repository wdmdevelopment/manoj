package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RequestShowDetails {

	//private RequestTheatre theatrename;

	
	//private RequestCinema cinema;

	//@Column(name = "START_TIME")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private String showTime;

	
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

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@Column(name = "DATE")
	private String date;
	
	private long id;





	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
