package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Theatre;
import com.example.demo.model.RequestTheatre;
import com.example.demo.repository.TheatreRepository;
import com.example.demo.service.TheatreService;

@Service
public class TheatreServiceimpl implements TheatreService {

	@Autowired

	TheatreRepository theatreRepository;

	public List<RequestTheatre> getAllTheatre() {
		
		

		return new theatreRepository.findAll();
	}

	public RequestTheatre getTheatreById(long id) {

		Theatre obj = theatreRepository.findById(id).get();

		RequestTheatre obj1 = new RequestTheatre();///ERROR
		obj.getTheatrename();
		obj.getListOfShow();
		obj.getAddress();
																					
		obj1.setTheatrename(obj.getTheatrename());
		obj1.getListOfShow(obj.getListOfShow());
		obj1.setAddress(obj.getAddress());
		return obj1;

	}

	public void delete(long id) {

		theatreRepository.deleteById(id);
	}

	public Theatre save(RequestTheatre theatre) {
		
		Address a= new Address();
				a.getPincode();
				a.getDistrict();
				a.getState();
				a.getStreet();
		Theatre t = new Theatre();
		
		t.setAddress(a);
		return theatreRepository.save(t);
	}

	public Theatre update(Theatre theatre) {

		return theatreRepository.save(theatre);
	}

}
