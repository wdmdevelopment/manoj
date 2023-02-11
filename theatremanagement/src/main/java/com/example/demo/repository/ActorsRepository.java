package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Actors;
import com.example.demo.model.RequestCinema;

@Repository
public interface ActorsRepository extends JpaRepository<Actors, Long> {



}
