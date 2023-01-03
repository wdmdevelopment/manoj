package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Theatre;
import com.example.demo.repository.TheatreRepository;
import com.example.demo.service.TheatreService;

@Service
public class TheatreServiceimpl implements TheatreService {

	@Autowired

	TheatreRepository theatreRepository;

	public List<Theatre> getAllTheatreModels() {

		return theatreRepository.findAll();
	}

	public Theatre getTheatreModelById(long theatreid) {

		return theatreRepository.findById(theatreid).get();
	}

	public void delete(long theatreid) {

		theatreRepository.deleteById(theatreid);
	}

	public void save(Theatre theatre) {

		theatreRepository.save(theatre);
	}

	public Theatre update(Theatre theatre) {

		return theatreRepository.save(theatre);
	}

}
