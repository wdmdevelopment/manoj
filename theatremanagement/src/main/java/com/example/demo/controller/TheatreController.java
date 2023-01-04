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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ResponseTheatre;
import com.example.demo.exceptionhandler.NotFoundException;
import com.example.demo.model.Theatre;
import com.example.demo.service.TheatreService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/allTheatre")
public class TheatreController {

	@Autowired
	TheatreService theatreService;

	@Autowired

	ObjectMapper objectmapperl;

	@GetMapping
	public List<Theatre> getAllTheatre() {
		return theatreService.getAllTheatre();
	}

	@GetMapping("{id}")
	public ResponseEntity<ResponseTheatre> getTheatreModel(@PathVariable("id") long id) {

		return new ResponseEntity<>(theatreService.getTheatreById(id), HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public void deleteTheatreModel(@PathVariable("id") long id) {
		theatreService.delete(id);

	}

	@PostMapping("/sent")
	public Theatre save(@RequestBody Theatre theatre) {

		try {
			theatreService.save(theatre);
			return theatre;
		} catch (Exception e) {

			throw new NotFoundException("input give properly");
		}

	}

	@PutMapping("/update/{id}")
	public Theatre update(@RequestBody Theatre theatre) {
		ResponseTheatre obj = theatreService.getTheatreById(theatre.getId());
		try {
			if (obj == null)
				;
		} catch (Exception e) {
			throw new NotFoundException("Theatre id  notfound");
		}
		theatreService.update(theatre);
		return theatre;

//		if (obj == null) {
//
//			throw new NotFoundException("Theatre id notfound");
//		} else {
//			theatreService.update(theatre);
//		}
//
//		return theatre;
	}

}
