package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@OneToMany(mappedBy = "booking", cascade = {CascadeType.PERSIST , CascadeType.MERGE})
//	@JoinTable(name = "Booking_Seats_Map", joinColumns = { @JoinColumn(name = "BOOKING_ID") }, inverseJoinColumns = {
//			@JoinColumn(name = "SEAT_ID") })
	private List<BookingSeats> seats;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID", referencedColumnName = "user_id")
	private User user;

	
	private LocalDateTime bookingTime;
	
	
	
	public User getUser() {
		return user;
	}

	
	public void setUser(User user) {
		this.user = user;
	}

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


	public LocalDateTime getBookingTime() {
		return bookingTime;
	}


	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}


	 



}
