package com.example.demo.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Booking;
import com.example.demo.model.RequestBooking;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingrepository;

	@Override
	public Booking savebooking(RequestBooking booking) {
		booking.getCinemaId();
		booking.getUser_id();
		booking.getShowDetailsid();
		booking.getShowDetailsid();
		Booking Booking = new Booking();
		Booking.setCinema(booking.getCinemaId());
		Booking.setShowdetails(booking.getShowDetailsid());
		Booking.setTheatre(booking.getTheatreId());
		return bookingrepository.save(Booking);

	}

	@Override
	public List<Booking> getAllBooking() {

		return bookingrepository.findAll();
	}

	@Override
	public Booking getBookingById(long id) {

		return bookingrepository.findById(id).get();
	}

	@Override
	public Booking updateBooking(Booking booking) {

		return bookingrepository.save(booking);
	}

	@Override
	public void deleteBooking(long id) {
		bookingrepository.deleteById(id);
	}

}
