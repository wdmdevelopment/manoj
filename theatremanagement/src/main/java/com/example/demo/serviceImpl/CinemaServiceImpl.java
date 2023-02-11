package com.example.demo.serviceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Actors;
import com.example.demo.entity.Cinema;
import com.example.demo.entity.User;
import com.example.demo.exceptionhandler.CinemaNotFoundException;
import com.example.demo.exceptionhandler.NotFoundException;
import com.example.demo.exceptionhandler.TheatreNotFoundException;
import com.example.demo.exceptionhandler.UserNotAllowedException;
import com.example.demo.model.RequestCinema;
import com.example.demo.repository.ActorsRepository;
import com.example.demo.repository.CinemaRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CinemaService;

@Service
public class CinemaServiceImpl implements CinemaService {

	@Autowired
	CinemaRepository cinemaRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ActorsRepository actorsRepository;

	
	
	@Override
	public Cinema savecinema(RequestCinema cinema) {
		
		try {
		
			Cinema obj = new Cinema();
			
			obj.setMovieName(cinema.getMovieName());
			obj.setLanguage(cinema.getLanguage());
			obj.setRating(cinema.getRating());
			obj.setPoster(cinema.getPoster());
			obj.setReleasedYear(cinema.getReleasedYear());
			obj.setId(cinema.getUserid());
			
			
			
			Actors actors = new Actors();
			actors.setActor(cinema.getActor());
			actors.setActress(cinema.getActress());
			actors.setDirecter(cinema.getDirecter());
			actors.setMusicDirecter(cinema.getMusicDirecter());
			actors.setReleasedYear(cinema.getReleasedYear());
			List<Actors> actorList = new ArrayList<>();
			
			actorList.add(actors);
		
			obj.setActors(actorList);
			


			
 
			return cinemaRepository.save(obj);
		}
		catch (Exception e) {
			throw  new NotFoundException(e.getMessage());
		}
	}

	@Override
	public List<Cinema> getAllCinema() {

		return cinemaRepository.findAll();
	}

	@Override
	public Cinema getCinemaById(long id) {

		return cinemaRepository.findById(id).orElseThrow(() -> new CinemaNotFoundException("" + id));
	}

	@Override
	public Cinema updateCinema(long id, RequestCinema requestCinema) {

		User findById = userRepository.findById(requestCinema.getUserid()).orElseThrow(() -> new TheatreNotFoundException("" + id));

		String role = findById.getRole();
		
		
		if (role.equalsIgnoreCase("admin")) {
			
			Cinema obj = cinemaRepository.findById(id).orElseThrow(() -> new NotFoundException("" + id));
			obj.setMovieName(requestCinema.getMovieName());
			obj.setLanguage(requestCinema.getLanguage());
			obj.setRating(requestCinema.getRating());
			obj.setPoster(requestCinema.getPoster());
			obj.setReleasedYear(requestCinema.getReleasedYear());
			
			return cinemaRepository.save(obj);
		} else {
			throw new UserNotAllowedException("admin only allowed");
		}
	}

	@Override
	public void deleteCinema(long id) {

		Optional<Cinema> findById = cinemaRepository.findById(id);
		if (findById.isPresent()) {
			cinemaRepository.deleteById(id);
		} else {
			throw new CinemaNotFoundException("Id not present");
		}

	}

	@Override
	public List<Cinema> findByCinema(String name) {
		return cinemaRepository.findByCinema(name);
		
	}

	

}
