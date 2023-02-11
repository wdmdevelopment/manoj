package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Theatre;
import com.example.demo.model.RequestTheatre;

@Service
public interface TheatreService {
	
	public Theatre saveTheatre(RequestTheatre theatre);

	public List<Theatre> getAllTheatre();

	public Theatre getTheatreById(long id);

	public Theatre updateTheatre(long id, RequestTheatre requestTheatre);

	public void deleteTheatre(long id);
	
	public List<Theatre> filterbyTheatreName(String tName);

}
