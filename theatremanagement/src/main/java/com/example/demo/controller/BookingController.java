package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Booking;
import com.example.demo.model.BookingResponce;
import com.example.demo.model.RequestBooking;
import com.example.demo.service.BookingService;


@RequestMapping("/Booking")
@RestController
@CrossOrigin
public class BookingController {

	@Autowired
	BookingService bookingService; 

	private static final Logger logger = LoggerFactory.getLogger(TheatreController.class);

	@PostMapping
	public ResponseEntity<Booking> savebooking(@RequestBody RequestBooking booking) {
		logger.info("creat Booking");
		return new ResponseEntity<>(bookingService.savebooking(booking), HttpStatus.OK);
	}

	@GetMapping("/getAllBooking")
	public List<Booking> getAllBooking() {
		return  bookingService.getAllBooking();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable("id") long id) {
		logger.info("get a Booking");
		return new ResponseEntity<>(bookingService.getBookingById(id), HttpStatus.OK);

	}

//	@PutMapping("/userId/{id}")
//	public ResponseEntity<Booking> updateBooking(@PathVariable long id, @RequestBody RequestBooking booking,
//			@RequestParam("user") long userid) {
//		logger.info("update a Booking");
//		return new ResponseEntity<>(bookingService.updateBooking(id, booking, userid), HttpStatus.OK);
//
//	}

	@DeleteMapping("/{id}")
	public void deleteBooking(@PathVariable("id") long id) {
		logger.info("delete a Booking");
		bookingService.deleteBooking(id);

	}
	
	@GetMapping("user/{id}")
	public ResponseEntity<List<Booking>> getUserById(@PathVariable("id") long id) {
		logger.info("get a Booking");
		return new ResponseEntity<>(bookingService.findUser(id), HttpStatus.OK);

	}
	
	@GetMapping("userBook/{id}")
	public ResponseEntity<List<BookingResponce>> getUserByBooking(@PathVariable("id") long id) {
		logger.info("get a Booking");
		return new ResponseEntity<>(bookingService.findBookingDetails(id), HttpStatus.OK);

	}
	
	
	@GetMapping("show/{seatId}")
	public ResponseEntity<List<Integer>> getSeatsByBookingAndShow(@PathVariable("seatId") long seatId) {
		logger.info("get a Booking");
		return new ResponseEntity<>(bookingService.getSeatsByBookingAndShow(seatId), HttpStatus.OK);

	}

}
