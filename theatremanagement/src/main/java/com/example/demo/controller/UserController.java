package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.User;
import com.example.demo.model.RequestLogin;
import com.example.demo.model.RequestUser;
import com.example.demo.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(TheatreController.class);

	@PostMapping("/create")
	public ResponseEntity<User> saveUser(@Valid @RequestBody RequestUser user) {
		logger.info("creat new User");
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		logger.info("get a allUser");
		return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@Valid @PathVariable("id") long id) {
		logger.info("get a User");
		User theUser = userService.getUserById(id);

		if (theUser == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(theUser);

	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@Valid @PathVariable long id, @RequestBody RequestUser requestUser) {
		logger.info("update a User");
		User theUser = userService.updateUser(id, requestUser);

		if (theUser == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(theUser);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@Valid @PathVariable("id") long id) {
		logger.info("delete a theatre");
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}
	
	@PostMapping("/login")
	public ResponseEntity<User> login(RequestLogin loginRequest) {
		logger.info("login User");
		return new ResponseEntity<>(userService.login(loginRequest.getEmail(), loginRequest.getPass()), HttpStatus.OK);

}
}
