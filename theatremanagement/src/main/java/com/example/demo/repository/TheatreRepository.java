package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
	
	
	@Query(value = "SELECT * FROM theatre WHERE theatrename LIKE %:theatrename%", nativeQuery = true)
	public List<Theatre> findByTheatre(String theatrename);
	
	@Query(value = "select * from theatre  WHERE id LIKE %:id%", nativeQuery = true)
	 public  List<Theatre> findByTheatre(long id);
	
	List<Theatre> findAllByListOfShowCinemaId(long id);
	
}
