package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;
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
		} catch (Exception e) {
			throw new TheatreNotFoundException("" + e.getMessage());
		}
	}

	public List<Theatre> getAllTheatre() {
		return theatreRepository.findAll();
	}

	public Theatre getTheatreById(long id) {
		Theatre findById = theatreRepository.findById(id).orElseThrow(() -> new TheatreNotFoundException("" + id));
		return findById;
	}

	public Theatre updateTheatre(long id, RequestTheatre requestTheatre) {
		Theatre obj = theatreRepository.findById(id).orElseThrow(() -> new TheatreNotFoundException("" + id));
		Address address = new Address();
		address.setCity(requestTheatre.getCity());
		address.setState(requestTheatre.getState());
		address.setStreet(requestTheatre.getStreet());
		address.setPhoneNumber(requestTheatre.getPhoneNumber());
		obj.setTheatrename(requestTheatre.getTheatrename());
		obj.setNumberofrows(requestTheatre.getNumberofrows());
		obj.setNumberofseats(requestTheatre.getNumberofseats());
		obj.setAddress(address);
		return obj;
	}

	public void deleteTheatre(long id) {

		Optional<Theatre> findById = theatreRepository.findById(id);
		if (findById.isPresent()) {
			theatreRepository.deleteById(id);
		} else {
			throw new TheatreNotFoundException("Id not present");
		}
	}

}
