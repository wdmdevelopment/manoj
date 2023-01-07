package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cinema;
import com.example.demo.model.RequestCinema;
import com.example.demo.repository.CinemaRepository;
import com.example.demo.service.CinemaService;
@Service
public class CinemaServiceImpl implements CinemaService {

	@Autowired
	CinemaRepository cinemaRepository;

	@Override
	public Cinema savecinema(RequestCinema cinema) {

		Cinema obj = new Cinema();

		obj.setMovieName(cinema.getMovieName());
		obj.setLanguage(cinema.getLanguage());
		obj.setRating(cinema.getRating());
		obj.setReleasedYear(cinema.getReleasedYear());
		return cinemaRepository.save(obj);
	}

	@Override
	public List<Cinema> getAllCinema() {

		return cinemaRepository.findAll();
	}

	@Override
	public Cinema getCinemaById(long id) {

		return null;
	}

	@Override
	public Cinema updateCinema(Cinema cinema) {

		return cinemaRepository.save(cinema);
	}

	@Override
	public void deleteCinema(long id) {
		cinemaRepository.deleteById(id);

	}

}
