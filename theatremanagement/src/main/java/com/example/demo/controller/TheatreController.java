package com.example.demo.controller;

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
import com.example.demo.entity.Theatre;
import com.example.demo.model.RequestTheatre;
import com.example.demo.service.TheatreService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/Theatre")
public class TheatreController {

	@Autowired

	TheatreService theatreService;

	private static final Logger logger = LoggerFactory.getLogger(TheatreController.class);

	@PostMapping("/new")
	public ResponseEntity<Theatre> saveTheatre( @RequestBody RequestTheatre theatre) {

		logger.info("creat theater");

		return new ResponseEntity<>(theatreService.saveTheatre(theatre), HttpStatus.OK);
	}

	@GetMapping("/total")
	public List<Theatre> getAllTheatre() {
		logger.info("get a alltheatre");
		return theatreService.getAllTheatre();
	}

	@GetMapping("{id}")
	public ResponseEntity<Theatre> getTheatreById(@PathVariable("id") long id) {
		logger.info("get a theatre");
		Theatre theTheatre = theatreService.getTheatreById(id);

		if (theTheatre == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(theTheatre);

	}

	@PutMapping("{id}")
	public ResponseEntity<Theatre> updateTheatre(@PathVariable long id,
			@RequestBody RequestTheatre requestTheatre) {
		logger.info("update a theatre");
		Theatre theate = theatreService.updateTheatre(id, requestTheatre);
		if (theate == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(theate);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTheatre(@PathVariable("id") long id) {
		theatreService.deleteTheatre(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
