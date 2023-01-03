package com.example.demo.model;

import java.sql.Date;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SHOWDETAILS")

public class ShowDetails {

	@Id
	@Column(name = "show_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(name = "theatre_id")
	@JsonIgnore
	private Theatre theatrename;

	@ManyToMany
	private List<Cinema> cinema;

	@Column(name = "showTime")
	private String showTime;

	@Column(name = "date")
	@JsonFormat(pattern = "yyyy-mm-dd")
	private String date;

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

	public Theatre getTheatrename() {
		return theatrename;
	}

	public void setTheatrename(Theatre theatrename) {
		this.theatrename = theatrename;
	}

	public long getId() {
		return id;
	}

	public ShowDetails(long id, Theatre theatrename, List<Cinema> cinema, String showTime, String date) {
		super();
		this.id = id;
		this.theatrename = theatrename;
		this.cinema = cinema;
		this.showTime = showTime;
		this.date = date;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Cinema> getCinema() {
		return cinema;
	}

	public void setCinema(List<Cinema> cinema) {
		this.cinema = cinema;
	}

}
