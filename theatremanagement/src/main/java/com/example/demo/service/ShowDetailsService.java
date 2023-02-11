package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.ShowDetails;
import com.example.demo.model.RequestShowDetails;
import com.example.demo.model.ResponseShow;
@Service
public interface ShowDetailsService {

	public ShowDetails saveShowDetails(RequestShowDetails ShowDetails);

	public List<ShowDetails> getAllShowDetails();

	public ShowDetails getShowDetailsById(long id);

	public ShowDetails updateShowDetails(long id, RequestShowDetails requestShowDetails, long userid);

	public void deleteShowDetails(long id);
	
	public List<ShowDetails> getBytheatre(long Id);

	public ResponseShow getBycinema(long id);

	//ResponseEntity<RequestShowDetails> getBycategory(long Id);

}
