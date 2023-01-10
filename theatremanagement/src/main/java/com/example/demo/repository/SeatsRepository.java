package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BookingSeats;
@Repository
public interface SeatsRepository extends JpaRepository<BookingSeats, Long> {

}
