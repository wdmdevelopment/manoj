package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Theatre;
import com.example.demo.exceptionhandler.NotFoundException;
import com.example.demo.model.RequestTheatre;
import com.example.demo.service.TheatreService;

@RestController
@RequestMapping("/allTheatre")
public class TheatreController {

	@Autowired
	TheatreService theatreService;

	@GetMapping
	public ResponseEntity<RequestTheatre> getAllTheatre() {

		return new ResponseEntity<>(theatreService.getAllTheatre(), HttpStatus.OK);
	}

	@GetMapping("{id}")

	public ResponseEntity<RequestTheatre> getTheatreModel(@PathVariable("id") long id) {

		return new ResponseEntity<>(theatreService.getTheatreById(id), HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public void deleteTheatreModel(@PathVariable("id") long id) {
		theatreService.delete(id);

	}

	@PostMapping("/sent")
	public RequestTheatre save(@Valid @RequestBody RequestTheatre theatre) {

		try {
			theatreService.save(theatre);
			return (RequestTheatre) theatre;
		} catch (Exception e) {

			throw new NotFoundException("input give properly");
		}

	}

	@PutMapping("/update/{id}")
	public Theatre update(@RequestBody Theatre theatre) {
		RequestTheatre obj = theatreService.getTheatreById(theatre.getId());

		if (obj == null) {

			throw new NotFoundException("Theatre id notfound");
		} else {
			theatreService.update(theatre);
		}

		return theatre;
	}

}
