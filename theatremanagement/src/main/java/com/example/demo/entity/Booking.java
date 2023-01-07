package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKING")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOKING_ID")
	private long id;

	@OneToOne
	@JoinColumn(name = "theatre_id")
	private Theatre theatre;

	@OneToOne
	private ShowDetails showdetails;

	@OneToOne
	@JoinColumn(name = "cinema_id")
	private Cinema cinema;

	@OneToMany
	@JoinTable(name = "Booking_Seats_Map", joinColumns = { @JoinColumn(name = "BOOKING_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "SEAT_ID") })

	private List<BookingSeats> seats;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public ShowDetails getShowdetails() {
		return showdetails;
	}

	public void setShowdetails(ShowDetails showdetails) {
		this.showdetails = showdetails;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public List<BookingSeats> getSeats() {
		return seats;
	}

	public void setSeats(List<BookingSeats> seats) {
		this.seats = seats;
	}

}
