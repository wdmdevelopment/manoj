package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cinema;
import com.example.demo.entity.ShowDetails;
import com.example.demo.entity.Theatre;
import com.example.demo.entity.User;
import com.example.demo.exceptionhandler.NotFoundException;
import com.example.demo.exceptionhandler.TheatreNotFoundException;
import com.example.demo.exceptionhandler.UserNotAllowedException;
import com.example.demo.model.RequestShowDetails;
import com.example.demo.model.ResponseShow;
import com.example.demo.repository.CinemaRepository;
import com.example.demo.repository.ShowRepository;
import com.example.demo.repository.TheatreRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ShowDetailsService;

@Service
public class ShowDetailsServiceImpl implements ShowDetailsService {

	@Autowired

	ShowRepository showRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TheatreRepository theatreRepository;
	
	@Autowired
	CinemaRepository cinemaRepository;
	

	@Override
	public ShowDetails saveShowDetails(RequestShowDetails ShowDetails) {
		try {
		Theatre findById = theatreRepository.findById(ShowDetails.getTheatreId()).
				orElseThrow(() -> new UserNotAllowedException("theatre id not found" ));
		
		Cinema findBy = cinemaRepository.findById(ShowDetails.getCinemaId()).
				orElseThrow(() -> new UserNotAllowedException("cinema id not found" ));
		
			ShowDetails details = new ShowDetails();
			details.setDate(ShowDetails.getDate());
			details.setShowTime(ShowDetails.getShowTime());
			details.setCinema(findBy);
			details.setTheatrename(findById);
			
			return showRepository.save(details);
			
		}
		catch (Exception e) {
			throw new NotFoundException(e.getMessage());
		}
		
	}

	@Override
	public List<ShowDetails> getAllShowDetails() {

		return showRepository.findAll();
	}

	@Override
	public ShowDetails getShowDetailsById(long id) {
		try {
			ShowDetails obj = showRepository.findById(id).get();
			return obj;
		} catch (Exception e) {
			System.out.println(e);

		}
		return null;

	}

	@Override
	public ShowDetails updateShowDetails(long id, RequestShowDetails requestShowDetails, long userid) {

		User findById = userRepository.findById(userid).orElseThrow(() -> new UserNotAllowedException("" + id));

		String getuserRoll = findById.getRole();
		if (getuserRoll.equalsIgnoreCase("admin")) {
			ShowDetails obj = showRepository.findById(id).orElseThrow(() -> new NotFoundException("" + id));
			obj.setDate(requestShowDetails.getDate());
			obj.setShowTime(requestShowDetails.getShowTime());
			return obj;
		} else {
			throw new UserNotAllowedException("admin only allowed");
		}

	}

	@Override
	public void deleteShowDetails(long id) {

		Optional<ShowDetails> findById = showRepository.findById(id);
		if (findById.isPresent()) {
			showRepository.deleteById(id);
		} else {
			throw new TheatreNotFoundException("Id not present");
		}

	}

	@Override
	public List<ShowDetails> getBytheatre(long id) {
		
	List<ShowDetails> obj= showRepository.findByTheatrename_id(id);
		
		return obj;
	}

	@Override
	public ResponseShow getBycinema(long id) {
		ResponseShow show = new ResponseShow();
		Optional<Cinema> findById = cinemaRepository.findById(id);
		if(!findById.isPresent()) {
			throw new NotFoundException("Cinema not found");
		}
		
		Cinema cinema = findById.get();
		
		List<Theatre> theaters = theatreRepository.findAllByListOfShowCinemaId(id);
		System.out.println(theaters);
		
		for(Theatre t : theaters) {
			List<ShowDetails> collect = t.getListOfShow().stream()
					.filter(e -> e.getCinema().getId()==id)
					.collect(Collectors.toList());
			t.setListOfShow(collect);
		}
		
		
		show.setCinemaId(cinema.getId());
		show.setMovieName(cinema.getMovieName());
		show.setPoster(cinema.getPoster());
		
		show.setTheatres(theaters);
		
//		List<ResponseShowDetails> lst = new ArrayList<>();
//		for(ShowDetails show: findBy) {
//			show.getTheatrename()
//		}
		
		
		//findBy.stream().collect(Collectors.toMap(ShowDetails::getTheatrename, ShowDetails::getTheatrename))
		
		//Theatre findById = theatreRepository.findById(id).orElseThrow(() -> new NotFoundException(""+id));
		
		//findById.getTheatrename();
		return show;
	}


	



}
