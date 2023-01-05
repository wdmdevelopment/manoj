package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;




import org.springframework.stereotype.Repository;

import com.example.demo.entity.Theatre;
import com.example.demo.model.RequestTheatre;
@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long>{


}
