package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.demo.model.Theatre;

@Service
public interface TheatreService {

	List<Theatre> getAllTheatreModels();

	Theatre getTheatreModelById(long theatreid);

	void delete(long theatreid);
	
	void save(Theatre theatre);	
	
	public Theatre update(Theatre Theatre);

}
