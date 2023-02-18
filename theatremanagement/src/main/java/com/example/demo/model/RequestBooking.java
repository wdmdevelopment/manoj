package com.example.demo.model;

import java.util.List;

public class RequestBooking {
	
	private long theatreId;
	
	private long cinemaId;
	
	private long showDetailsid;
	
	private long user_id;
	
	private List<Integer> seatNumber;

	public long getTheatreId() {
		return theatreId;
	}

	public long setTheatreId(long theatreId) {
		return this.theatreId = theatreId;
	}

	public long getCinemaId() {
		return cinemaId;
	}

	public long setCinemaId(long cinemaId) {
		return this.cinemaId = cinemaId;
	}

	public long getUser_id() {
		return user_id;
	}

	public long setUser_id(long user_id) {
		return this.user_id = user_id;
	}

	public long getShowDetailsid() {
		return showDetailsid;
	}

	public long setShowDetailsid(long showDetailsid) {
		return this.showDetailsid = showDetailsid;
	}



	public List<Integer> getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(List<Integer> seatNumber) {
		this.seatNumber = seatNumber;
	}
	

}
