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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cinema;

import com.example.demo.model.RequestCinema;

import com.example.demo.service.CinemaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
public class CinemaController {

	@Autowired
	CinemaService cinemaService;

	@PostMapping("/new")
	public ResponseEntity<Cinema> savecinema(@RequestBody RequestCinema cinema) {

		return new ResponseEntity<>(cinemaService.savecinema(cinema), HttpStatus.OK);
	}
	
	@GetMapping("/total")
	public ResponseEntity<List<Cinema>> getAllCinema() {
		return new ResponseEntity<>(cinemaService.getAllCinema(),HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Cinema> getCinemaById(@PathVariable("id") long id) {
		return new ResponseEntity<>(cinemaService.getCinemaById(id), HttpStatus.OK);

	}

	@PutMapping("{id}")
	public ResponseEntity<Cinema> updateCinema(@RequestBody Cinema cinema) {

		return new ResponseEntity<>(cinemaService.updateCinema(cinema), HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public void deleteCinema(@PathVariable("id") long id) {

		cinemaService.deleteCinema(id);

	}

}
