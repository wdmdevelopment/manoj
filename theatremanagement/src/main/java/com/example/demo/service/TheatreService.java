package com.example.demo.service;



import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Theatre;
import com.example.demo.model.RequestTheatre;

@Service
public interface TheatreService {

	ResponseEntity<RequestTheatre> getAllTheatre();

	RequestTheatre getTheatreById(long theatreid);

	void delete(long theatreid);

	Theatre save(RequestTheatre theatre);

	public Theatre update(Theatre Theatre);

}
