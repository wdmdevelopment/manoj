package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ResponseTheatre;
import com.example.demo.model.Theatre;

@Service
public interface TheatreService {

	List<Theatre> getAllTheatre();

	ResponseTheatre getTheatreById(long theatreid);

	void delete(long theatreid);

	Theatre save(Theatre theatre);

	public Theatre update(Theatre Theatre);

}
