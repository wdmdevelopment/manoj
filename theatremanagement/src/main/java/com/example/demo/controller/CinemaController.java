package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;
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
import com.example.demo.entity.Cinema;
import com.example.demo.entity.Theatre;
import com.example.demo.model.RequestCinema;
import com.example.demo.service.CinemaService;

@RestController
@RequestMapping("/cinema")
@CrossOrigin
public class CinemaController {

	@Autowired
	CinemaService cinemaService;

	private static final Logger logger = LoggerFactory.getLogger(TheatreController.class);

	@PostMapping("/create")

	public ResponseEntity<Cinema> savecinema(@Valid @RequestBody RequestCinema cinema
			) {

		logger.info("creat Cinema");

		Cinema thacinema = cinemaService.savecinema(cinema);
		 
//		if (thacinema == null) {
//			return ResponseEntity.notFound().build();
//		}
		return ResponseEntity.ok().body(thacinema);
	}

	@GetMapping
	public ResponseEntity<List<Cinema>> getAllCinema() {
		logger.info("get a allCinema");
		return new ResponseEntity<>(cinemaService.getAllCinema(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cinema> getCinemaById(@Valid @PathVariable("id") long id) {
		logger.info("get a Cinema");
		return new ResponseEntity<Cinema>(cinemaService.getCinemaById(id), HttpStatus.OK);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Cinema> updateCinema(@Valid @PathVariable long id, @RequestBody RequestCinema requestCinema
			) {
		logger.info("update a cinema");
		Cinema newcinema = cinemaService.updateCinema(id, requestCinema);
		if (newcinema == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(newcinema);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCinema(@Valid @PathVariable("id") long id) {
		logger.info("delete a theatre");
		cinemaService.deleteCinema(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}
	
	
	@GetMapping("/searchbycinemaname")
	public ResponseEntity<List<Cinema>> getCinemaByName(@RequestParam("movieName") String name) {
		logger.info("get a theatre");
		List<Cinema> theCinema = cinemaService.findByCinema(name);

		if (theCinema == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(theCinema);

	}
	

}
