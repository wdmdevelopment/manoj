package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.model.RequestBooking;
@Service
public interface BookingService {

	public Booking savebooking(RequestBooking booking);

	public List<Booking> getAllBooking();

	public Booking getBookingById(long id);

	public Booking updateBooking(Booking booking);

	public void deleteBooking(long id);

}
