package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Cinema;
import com.example.demo.model.RequestCinema;


@Service
public interface CinemaService {
	
	
	public Cinema savecinema(RequestCinema cinema);
	public List<Cinema> getAllCinema();
	public Cinema getCinemaById(long id);
	public Cinema updateCinema(Cinema cinema);
	public void deleteCinema(long id);

}
