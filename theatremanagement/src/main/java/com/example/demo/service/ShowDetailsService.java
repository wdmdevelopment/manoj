package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.ShowDetails;
import com.example.demo.entity.Theatre;
import com.example.demo.model.RequestShowDetails;

@Service
public interface ShowDetailsService {

	public ShowDetails saveShowDetails(RequestShowDetails ShowDetails);

	public List<ShowDetails> getAllShowDetails();

	public ShowDetails getShowDetailsById(long id);

	public ShowDetails updateShowDetails(long id, RequestShowDetails requestShowDetails, long userid);

	public void deleteShowDetails(long id);
	
	public List<ShowDetails> getBytheatre(long Id);

	//ResponseEntity<RequestShowDetails> getBycategory(long Id);

}
