package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.Actors;
import com.example.demo.model.RequestActors;
public interface ActorsService {
	
	public Actors saveActors(RequestActors actors);
	public List<Actors> getAllActors();

}
