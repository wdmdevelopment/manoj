package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Theatre;
import com.example.demo.model.RequestTheatre;

@Service
public interface TheatreService {
	
	public Theatre saveTheatre(RequestTheatre theatre, long userid);

	public List<Theatre> getAllTheatre();

	public Theatre getTheatreById(long id);

	public Theatre updateTheatre(long id, RequestTheatre requestTheatre,long userid);

	public void deleteTheatre(long id);
	public List<Theatre> filterbyTheatreName(String tName);

}
