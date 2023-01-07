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

import com.example.demo.entity.Theatre;
import com.example.demo.model.RequestTheatre;
import com.example.demo.service.TheatreService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/Theatre")
public class TheatreController {

	@Autowired

	TheatreService theatreService;

	@PostMapping("/new")
	public ResponseEntity<Theatre> saveTheatre(@RequestBody RequestTheatre theatre) {

		return new ResponseEntity<>(theatreService.saveTheatre(theatre), HttpStatus.OK);
	}

	@GetMapping("/total")
	public ResponseEntity<List<Theatre>> getAllTheatre() {
		return new ResponseEntity<>(theatreService.getAllTheatre(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Theatre> getTheatreById(@PathVariable("id") long id) {
		
		Theatre	theTheatre= theatreService.getTheatreById(id);
		if(theTheatre==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(theTheatre);

	}

	@PutMapping("{id}")
	public ResponseEntity<Theatre> updateTheatre(@RequestBody Theatre theatre) {
		
		

		return new ResponseEntity<>(theatreService.updateTheatre(theatre), HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<Theatre> deleteTheatre(@PathVariable("id") long id) {
		Theatre	theTheatre= theatreService.deleteTheatre(id);
		if(theTheatre==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(theTheatre);

	}

}
