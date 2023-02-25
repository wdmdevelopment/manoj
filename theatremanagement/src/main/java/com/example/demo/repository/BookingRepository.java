package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Theatre;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	 public  List<Booking> findByUser_id(long id);
	 
	 public  List<Booking> findByShowdetailsId(long id);
	
}
