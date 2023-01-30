package com.example.demo.serviceImpl;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Address;
import com.example.demo.entity.Theatre;
import com.example.demo.entity.User;
import com.example.demo.exceptionhandler.TheatreNotFoundException;
import com.example.demo.exceptionhandler.UserNotAllowedException;
import com.example.demo.model.RequestTheatre;
import com.example.demo.repository.TheatreRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TheatreService;

@Service
public class TheatreServiceimpl implements TheatreService {
	@Autowired
	TheatreRepository theatreRepository;

	@Autowired
	UserRepository userRepository;

	public Theatre saveTheatre(RequestTheatre requestTheatre, long userid) {

		User findById = userRepository.findById(userid).orElseThrow(() -> new TheatreNotFoundException("" + userid));
		String getuserRoll = findById.getRole();

		if (getuserRoll.equalsIgnoreCase("admin")) {

			Address address = new Address();
			address.setCity(requestTheatre.getCity());
			address.setState(requestTheatre.getState());
			address.setStreet(requestTheatre.getStreet());
			address.setPhoneNumber(requestTheatre.getPhoneNumber());
			address.setPincode(requestTheatre.getPincode());
			Theatre theatre = new Theatre();
			theatre.setTheatrename(requestTheatre.getTheatrename());
			theatre.setNumberofrows(requestTheatre.getNumberofrows());
			theatre.setNumberofseats(requestTheatre.getNumberofseats());
			theatre.setAddress(address);
			return theatreRepository.save(theatre);
		} else {

			throw new UserNotAllowedException("admin only allowed");
		}
	}

	public List<Theatre> getAllTheatre() {
		return theatreRepository.findAll();

	}

	public Theatre getTheatreById(long id) {
		Theatre findById = theatreRepository.findById(id).orElseThrow(() -> new TheatreNotFoundException("" + id));
		return findById;
	}

	public Theatre updateTheatre(long id, RequestTheatre requestTheatre, long userid) {

		User findById = userRepository.findById(userid).orElseThrow(() -> new TheatreNotFoundException("" + id));

		String getuserRoll = findById.getRole();

		Theatre obj = null;

		if (getuserRoll.equalsIgnoreCase("admin") ) {

			obj = theatreRepository.findById(id).orElseThrow(() -> new TheatreNotFoundException("" + id));

			Address address = obj.getAddress();
			address.setCity(requestTheatre.getCity());
			address.setState(requestTheatre.getState());
			address.setStreet(requestTheatre.getStreet());
			address.setPhoneNumber(requestTheatre.getPhoneNumber());
			obj.setTheatrename(requestTheatre.getTheatrename());
			obj.setNumberofrows(requestTheatre.getNumberofrows());
			obj.setNumberofseats(requestTheatre.getNumberofseats());
			obj.setAddress(address);

		} else {
			throw new UserNotAllowedException("admin only allowed");
		}
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
	
public List<Theatre> filterbyTheatreName(String tName) {
		
		return theatreRepository.findByTheatre(tName);			
		 
		 
			 
	}

	
	
	
	

}
