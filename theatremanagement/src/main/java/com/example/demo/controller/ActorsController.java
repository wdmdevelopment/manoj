package com.example.demo.controller;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Actors;
import com.example.demo.model.RequestActors;
import com.example.demo.service.ActorsService;

@RestController
@RequestMapping("/actors")
public class ActorsController {
	
	
	@Autowired
	ActorsService actorsService;
	private static final Logger logger = LoggerFactory.getLogger(TheatreController.class);

	@PostMapping("/create")
	public ResponseEntity<Actors> saveActors(@Valid @RequestBody RequestActors actors) {
		logger.info("creat new Actors");
		return new ResponseEntity<>(actorsService.saveActors(actors), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Actors>> getAllActors() {
		logger.info("get a allActors");
		return new ResponseEntity<>(actorsService.getAllActors(), HttpStatus.OK);
	}
	

}
