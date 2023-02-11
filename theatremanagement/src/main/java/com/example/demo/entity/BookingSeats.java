package com.example.demo.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table
public class BookingSeats {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SEAT_ID")
	private long seat_id;
	
	@ManyToOne//map
	private Booking booking;
	
	public long getSeat_id() {
		return seat_id;
	}

	
	public void setSeat_id(long seat_id) {
		this.seat_id = seat_id;
	}

	

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}


	public static void main(String[] args) {
		
	}


}
