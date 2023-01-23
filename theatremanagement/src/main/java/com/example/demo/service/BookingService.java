package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.model.RequestBooking;

@Service
public interface BookingService {

	public Booking savebooking(RequestBooking booking,long userid);

	public List<Booking> getAllBooking();

	public Booking getBookingById(long id);

	//public Booking updateBooking(long id, RequestBooking booking,long userid);

	public void deleteBooking(long id);

}
