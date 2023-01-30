package com.example.demo.serviceImpl;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.ShowDetails;
import com.example.demo.entity.User;
import com.example.demo.exceptionhandler.NotFoundException;
import com.example.demo.exceptionhandler.TheatreNotFoundException;
import com.example.demo.exceptionhandler.UserNotAllowedException;
import com.example.demo.model.RequestShowDetails;
import com.example.demo.repository.ShowRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ShowDetailsService;

@Service
public class ShowDetailsServiceImpl implements ShowDetailsService {

	@Autowired

	ShowRepository showRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public ShowDetails saveShowDetails(RequestShowDetails ShowDetails) {

		//User findById = userRepository.findById(ShowDetails.get).orElseThrow(() -> new TheatreNotFoundException("" + userid));
		//String getuserRoll = findById.getRole();

		//if (getuserRoll.equalsIgnoreCase("admin")) {
			
			ShowDetails details = new ShowDetails();
			details.setDate(ShowDetails.getDate());
			details.setShowTime(ShowDetails.getShowTime());
			details.setId(ShowDetails.getId());
			return showRepository.save(details);
		//} else {
			//throw new UserNotAllowedException("admin only allowed");
		//}
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

}
