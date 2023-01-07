package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Booking;

import com.example.demo.model.RequestBooking;

import com.example.demo.service.BookingService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;



@RequestMapping("/Booking")
@RestController
public class BookingController {

	@Autowired
	BookingService bookingService;

	@PostMapping("/add")
	public ResponseEntity<Booking> savebooking(@RequestBody RequestBooking booking) {

		return new ResponseEntity<>(bookingService.savebooking(booking), HttpStatus.OK);
	}

	@GetMapping("/available")
	public ResponseEntity<List<Booking>> getAllBooking() {
		return new ResponseEntity<>(bookingService.getAllBooking(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable("id") long id) {
		return new ResponseEntity<>(bookingService.getBookingById(id), HttpStatus.OK);

	}

	@PutMapping("{id}")
	public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking) {

		return new ResponseEntity<>(bookingService.updateBooking(booking), HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public void deleteBooking(@PathVariable("id") long id) {

		bookingService.deleteBooking(id);

	}

}
