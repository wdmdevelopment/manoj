package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.model.RequestUser;

public interface UserService {
	public User saveUser(RequestUser user);

	public List<User> getAllUser();

	public User getUserById(long id);

	public User updateUser(long id, RequestUser requestUser);

	public void deleteUser(long id);
	
	public User login(String userName, String password);
}
