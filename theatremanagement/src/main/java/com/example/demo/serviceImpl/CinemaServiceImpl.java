package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cinema;
import com.example.demo.exceptionhandler.CinemaNotFoundException;
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

		try {
			Cinema one = cinemaRepository.findById(id).get();
			return one;
		} catch (Exception e) {
			throw new CinemaNotFoundException("" + e);
		}
	}

	@Override
	public Cinema updateCinema(long id, RequestCinema requestCinema) {
		
		
		Cinema obj = new Cinema();
		obj.setMovieName(requestCinema.getMovieName());
		obj.setLanguage(requestCinema.getLanguage());
		obj.setRating(requestCinema.getRating());
		obj.setReleasedYear(requestCinema.getReleasedYear());
		return obj;
		

//		try {
//			Cinema movie = cinemaRepository.save(requestCinema);
//			return movie;
//		} catch (Exception e) {
//
//			throw new CinemaNotFoundException("Cinema id is manitrory" + e);
//		}

	}

	@Override
	public void deleteCinema(long id) {
		cinemaRepository.deleteById(id);

	}

}
