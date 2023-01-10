package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ShowDetails;
import com.example.demo.model.RequestShowDetails;

@Service
public interface ShowDetailsService {

	public ShowDetails saveShowDetails(RequestShowDetails ShowDetails);

	public List<ShowDetails> getAllShowDetails();

	public ShowDetails getShowDetailsById(long id);

	public ShowDetails updateShowDetails(long id, RequestShowDetails requestShowDetails);

	public void deleteShowDetails(long id);

}
