package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

import com.example.demo.exceptionhandler.UserNotFoundException;
import com.example.demo.model.RequestUser;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(RequestUser user) {
		
		User obj = new User();
		obj.setUser_fname(user.getUser_fname());
		obj.setUser_lname(user.getUser_lname());
		obj.setUser_mobile(user.getUser_mobile());
		obj.setUser_role(user.getUser_role());
		return userRepository.save(obj);
		
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		
		try {
			User theUser = userRepository.findById(id).get();
			return theUser;
		} catch (Exception e) {
			throw new UserNotFoundException("User id give properly" + e);
		}
	}

	@Override
	public User updateUser(long id, RequestUser requestUser) {	
		User user = new User();
		user.setUser_fname(requestUser.getUser_fname());
		user.setUser_lname(requestUser.getUser_lname());
		user.setUser_mobile(requestUser.getUser_mobile());
		user.setUser_role(requestUser.getUser_role());
		return user;
	}

	@Override
	public void deleteUser(long id) {
		
		userRepository.deleteById(id);
	}
	
	
	

}
