package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmailAndPassword(String userName, String password);

	public User findByUserName(String userName);

	public Boolean existsByUserName(String userName);

	public Boolean existsByEmail(String email);
	
	public User findByUserNameOrPassword(String userName, String password);

}
