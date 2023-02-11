package com.example.demo.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Actors;
import com.example.demo.model.RequestActors;
import com.example.demo.repository.ActorsRepository;
import com.example.demo.service.ActorsService;

@Service
public class ActorsServiceImpl implements ActorsService{
	
	@Autowired
	ActorsRepository actorsRepository;

	@Override
	public Actors saveActors(RequestActors actors) {
		
		Actors obj = new Actors();
		obj.setActor(actors.getActor());
		obj.setActress(actors.getActress());
		obj.setDirecter(actors.getDirecter());
		obj.setMusicDirecter(actors.getMusicDirecter());
		obj.setReleasedYear(actors.getReleasedYear());
//		obj.setName(actors.getName());
//		obj.setRole(actors.getRole());
		return actorsRepository.save(obj);
	}

	@Override
	public List<Actors> getAllActors() {
		
		return actorsRepository.findAll();
	}

}
