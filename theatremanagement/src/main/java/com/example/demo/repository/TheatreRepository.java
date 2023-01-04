package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;




import org.springframework.stereotype.Repository;

import com.example.demo.entity.ResponseTheatre;
import com.example.demo.model.Theatre;
@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long>{


}
