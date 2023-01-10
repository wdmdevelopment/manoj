package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.example.demo.entity.Actors;
import com.example.demo.entity.Cinema;
import com.example.demo.model.RequestCinema;
import com.example.demo.service.CinemaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

	@Autowired
	CinemaService cinemaService;

	private static final Logger logger = LoggerFactory.getLogger(TheatreController.class);

	@PostMapping("/new")

	public ResponseEntity<Cinema> savecinema(@Valid @RequestBody RequestCinema cinema) {

		logger.info("creat Cinema");

		Cinema thacinema = cinemaService.savecinema(cinema);
		if (thacinema == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(thacinema);
	}

	@GetMapping("/total")
	public List<RequestCinema> getAllCinema() {

		logger.info("get a allCinema");

		List<Cinema> allCinema = cinemaService.getAllCinema();

		List<RequestCinema> res = new ArrayList<>();
		for (Cinema cinema : allCinema) {
			RequestCinema obj = new RequestCinema();
			Actors a = new Actors();
			obj.setMovieName(cinema.getMovieName());
			a.getDirector();
			a.getHero();
			a.getHeroine();
			a.getMusicDirector();
			a.getProducer();

			obj.setDirector(a.getDirector());
			obj.setHeroine(a.getHeroine());
			obj.setMusicDirector(a.getMusicDirector());
			res.add(obj);
		}
		return res;

		// return new ResponseEntity<>(cinemaService.getAllCinema(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Cinema> getCinemaById(@Valid @PathVariable("id") long id) {
		logger.info("get a Cinema");
		Cinema thecinema = cinemaService.getCinemaById(id);
		if (thecinema == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(thecinema);

	}

	@PutMapping("{id}")
	public ResponseEntity<Cinema> updateCinema(@Valid @PathVariable long id, @RequestBody RequestCinema requestCinema) {
		logger.info("update a theatre");
		Cinema newcinema = cinemaService.updateCinema(id, requestCinema);
		if (newcinema == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(newcinema);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteCinema(@Valid @PathVariable("id") long id) {
		logger.info("delete a theatre");
		cinemaService.deleteCinema(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

}
