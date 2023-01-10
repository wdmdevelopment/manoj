package com.example.demo.entity;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CINEMA", referencedColumnName = "cinema_id")

	private Cinema cinema;

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

	public long getId() {
		return id;
	}

//	public ShowDetails(long id, Theatre theatrename, Cinema cinema, String showTime, String date) {
//		super();
//		this.id = id;
//		this.theatrename = theatrename;
//		this.cinema = cinema;
//		this.showTime = showTime;
//		this.date = date;
//	}

	public Theatre getTheatrename() {
		return theatrename;
	}

	public void setTheatrename(Theatre theatrename) {
		this.theatrename = theatrename;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

}
