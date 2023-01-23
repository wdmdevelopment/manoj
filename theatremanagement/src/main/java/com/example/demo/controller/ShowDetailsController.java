package com.example.demo.controller;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ShowDetails;
import com.example.demo.model.RequestShowDetails;
import com.example.demo.service.ShowDetailsService;

@RestController
@RequestMapping("/ShowDetails")
public class ShowDetailsController {

	@Autowired
	ShowDetailsService ShowDetailsservice;
	private static final Logger logger = LoggerFactory.getLogger(TheatreController.class);

	@PostMapping
	public ResponseEntity<ShowDetails> saveShowDetails(@Valid @RequestBody RequestShowDetails ShowDetails,
			@RequestParam("user") long userid) {
		logger.info("creat ShowDetails");
		return new ResponseEntity<>(ShowDetailsservice.saveShowDetails(ShowDetails, userid), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<ShowDetails>> getAllShowDetails() {
		logger.info("get a allShowDetails");
		return new ResponseEntity<>(ShowDetailsservice.getAllShowDetails(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ShowDetails> getShowDetailsById(@Valid @PathVariable("id") long id) {
		logger.info("get a ShowDetails");

		ShowDetails theShowDetails = ShowDetailsservice.getShowDetailsById(id);

		if (theShowDetails == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(theShowDetails);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ShowDetails> updateShowDetails(@Valid @PathVariable long id,
			@RequestBody RequestShowDetails requestShowDetails, @RequestParam("user") long userid) {
		logger.info("update a ShowDetails");
		ShowDetails details = ShowDetailsservice.updateShowDetails(id, requestShowDetails, userid);

		if (details == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(details);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteShowDetails(@Valid @PathVariable("id") long id) {
		logger.info("delete a ShowDetails");
		ShowDetailsservice.deleteShowDetails(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

}
