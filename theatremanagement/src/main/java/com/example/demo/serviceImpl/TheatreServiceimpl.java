package com.example.demo.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.ResponseTheatre;
import com.example.demo.model.Theatre;
import com.example.demo.repository.TheatreRepository;
import com.example.demo.service.TheatreService;

@Service
public class TheatreServiceimpl implements TheatreService {

	@Autowired

	TheatreRepository theatreRepository;

	public List<Theatre> getAllTheatre() {

		return theatreRepository.findAll();
	}

	public ResponseTheatre getTheatreById(long id) {

		Theatre obj = theatreRepository.findById(id).get();

		ResponseTheatre obj1 = new ResponseTheatre();
		obj.getTheatrename();
		obj.getListOfShow();
		obj.getAddress();

		obj1.setTheatrename(obj.getTheatrename());
		obj1.setListOfShow(obj.getListOfShow());
		obj1.setAddress(obj.getAddress());
		return obj1;

	}

	public void delete(long id) {

		theatreRepository.deleteById(id);
	}

	public Theatre save(Theatre theatre) {

		return theatreRepository.save(theatre);
	}

	public Theatre update(Theatre theatre) {

		return theatreRepository.save(theatre);
	}

}
