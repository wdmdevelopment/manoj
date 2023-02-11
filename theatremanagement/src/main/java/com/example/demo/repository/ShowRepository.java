package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ShowDetails;
import com.example.demo.entity.Theatre;
@Repository
public interface ShowRepository extends JpaRepository<ShowDetails, Long>{

	List<ShowDetails> findByTheatrename_id(long id);

	
	
	List<ShowDetails> findByCinema_id(long id);
	
	
	
	


}
