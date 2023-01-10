package com.example.demo.model;

import com.example.demo.entity.Cinema;
import com.example.demo.entity.ShowDetails;
import com.example.demo.entity.Theatre;
import com.example.demo.entity.User;

public class RequestBooking {
	
	private Theatre theatreId;
	
	private Cinema cinemaId;
	
	private ShowDetails showDetailsid;
	
	private User user_id;

	public Theatre getTheatreId() {
		return theatreId;
	}

	public Theatre setTheatreId(Theatre theatreId) {
		return this.theatreId = theatreId;
	}

	public Cinema getCinemaId() {
		return cinemaId;
	}

	public Cinema setCinemaId(Cinema cinemaId) {
		return this.cinemaId = cinemaId;
	}

	public User getUser_id() {
		return user_id;
	}

	public User setUser_id(User user_id) {
		return this.user_id = user_id;
	}

	public ShowDetails getShowDetailsid() {
		return showDetailsid;
	}

	public ShowDetails setShowDetailsid(ShowDetails showDetailsid) {
		return this.showDetailsid = showDetailsid;
	}
	

}
