package com.example.demo.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Address;
import com.example.demo.entity.Theatre;
import com.example.demo.exceptionhandler.TheatreNotFoundException;
import com.example.demo.model.RequestTheatre;
import com.example.demo.repository.TheatreRepository;
import com.example.demo.service.TheatreService;

@Service
public class TheatreServiceimpl implements TheatreService {
	
	@Autowired
	TheatreRepository theatreRepository;

	public Theatre saveTheatre(RequestTheatre requestTheatre) {
		try {
		Address address = new Address();
		address.setCity(requestTheatre.getCity());
		address.setState(requestTheatre.getState());
		address.setStreet(requestTheatre.getStreet());
		address.setPhoneNumber(requestTheatre.getPhoneNumber());
		
		Theatre theatre = new Theatre();
		theatre.setTheatrename(requestTheatre.getTheatrename());
		theatre.setNumberofrows(requestTheatre.getNumberofrows());
		theatre.setNumberofseats(requestTheatre.getNumberofseats());
		theatre.setAddress(address);

		return theatreRepository.save(theatre);
		}catch (Exception e) {
			
			throw new TheatreNotFoundException("Theatre Details give properly");
		}
		
	}

	public List<Theatre> getAllTheatre() {
		
		return theatreRepository.findAll();
	}

	public Theatre getTheatreById(long id) {
		try {
			Theatre	 theatre= theatreRepository.findById(id).get();
		return theatre;
		}catch (Exception e) {
			throw new TheatreNotFoundException("Theatre id give properly");
		}
	}

	public Theatre updateTheatre(Theatre theatre) {

		return theatreRepository.save(theatre);
	}

	public void deleteTheatre(long id) {
		
		theatreRepository.deleteById(id);

	}

}
