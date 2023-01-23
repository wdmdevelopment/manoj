package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.exceptionhandler.NotFoundException;
import com.example.demo.exceptionhandler.UserNotAllowedException;
import com.example.demo.exceptionhandler.UserNotFoundException;
import com.example.demo.model.RequestUser;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(RequestUser user) {

		User obj = new User();
		obj.setFname(user.getFname());
		obj.setLname(user.getLname());
		obj.setMobile(user.getMobile());
		obj.setRole(user.getRole());
		obj.setPass(user.getPass());
		obj.setEmail(user.getEmail());
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
		user.setFname(requestUser.getFname());
		user.setLname(requestUser.getLname());
		user.setMobile(requestUser.getMobile());
		user.setRole(requestUser.getRole());
		return user;
	}

	@Override
	public void deleteUser(long id) {

		userRepository.deleteById(id);
	}
	
	public User login(String userName, String password){
		User user=userRepository.findByEmailAndPass(userName, password);
		if(user==null) {		
		throw new NotFoundException("invalid email and password");
		}
		return user;
		
	}

}
