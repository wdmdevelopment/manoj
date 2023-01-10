package com.example.demo.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.ShowDetails;
import com.example.demo.model.RequestShowDetails;
import com.example.demo.repository.ShowRepository;
import com.example.demo.service.ShowDetailsService;

@Service
public class ShowDetailsServiceImpl implements ShowDetailsService {

	@Autowired

	ShowRepository showRepository;

	@Override
	public ShowDetails saveShowDetails(RequestShowDetails ShowDetails) {

		ShowDetails details = new ShowDetails();
		details.setDate(ShowDetails.getDate());
		details.setShowTime(ShowDetails.getShowTime());
		return details;
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
	public ShowDetails updateShowDetails(long id, RequestShowDetails requestShowDetails) {

		ShowDetails details1 = new ShowDetails();

		details1.setDate(requestShowDetails.getDate());

		details1.setShowTime(requestShowDetails.getShowTime());
		return details1;

//		try {
//			ShowDetails theupdate = showRepository.save(requestShowDetails);
//			return theupdate;
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return null;

	}

	@Override
	public void deleteShowDetails(long id) {

		showRepository.deleteById(id);

	}

}
