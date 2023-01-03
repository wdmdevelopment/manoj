package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Theatre;
import com.example.demo.service.TheatreService;
 
@RestController
@RequestMapping("/allTheatre")
public class TheatreController {

	@Autowired
	TheatreService theatreService;

	@GetMapping
	public List<Theatre> getAllTheatreModels() {
		return theatreService.getAllTheatreModels();
	}

	@GetMapping("{Theatreid}")

	public Theatre getTheatreModel(@PathVariable("Theatreidid") long theatreid) {
		return theatreService.getTheatreModelById(theatreid);
	}

	@DeleteMapping("{TheatreModelsid}")
	public void deleteTheatreModel(@PathVariable("TheatreModelsid") long theatreid) {
		theatreService.delete(theatreid);

	}

	@PostMapping("/sent")
	public Theatre save(@RequestBody Theatre theatre) {
		theatreService.save(theatre);
		return theatre;
	}

	@PutMapping("/update")
	public Theatre update(@RequestBody Theatre theatre) {
		theatreService.update(theatre);
		return theatre;
	}

}
