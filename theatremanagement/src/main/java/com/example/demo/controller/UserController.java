package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.example.demo.exceptionhandler.NotFoundException;
import com.example.demo.model.RequestLogin;
import com.example.demo.model.RequestUser;
import com.example.demo.model.ResponseGoogle;
import com.example.demo.payload.response.JwtResponse;

import com.example.demo.repository.UserRepository;
import com.example.demo.security.security.jwt.JwtUtils;
import com.example.demo.security.service.UserDetailsImpl;
import com.example.demo.service.UserService;

//@RequestMapping("/user")

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

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

//	@PostMapping("/login")
//	public ResponseEntity<User> login(RequestLogin loginRequest) {
//		logger.info("login User");
//		return new ResponseEntity<>(userService.login(loginRequest.getUsername(), loginRequest.getPassword()), HttpStatus.OK);
//
//	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody RequestLogin loginRequest) {

		System.out.println(authenticationManager + "===========================================================>");

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		System.out.println(authentication + "---------------------------------------->");

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtUtils.generateJwtToken(authentication);
		System.out.println(jwt);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		return ResponseEntity
				.ok(new JwtResponse(jwt, userDetails.getId(),
						userDetails.getUsername(), userDetails.getEmail(),userDetails.getRole()));
	}

	@PostMapping("/signup")
	public User registerUser(@Valid @RequestBody RequestUser signUpRequest) {
		
		logger.info("User Register username={}", signUpRequest.getUserName());
		try {
		if (userRepository.existsByUserName(signUpRequest.getUserName())) {
//			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account

			User user = new User();
			user.setEmail(signUpRequest.getEmail());
			user.setMobile(signUpRequest.getMobile());
			user.setPassword(encoder.encode(signUpRequest.getPassword()));
			user.setRole(signUpRequest.getRole());
			user.setUserName(signUpRequest.getUserName());
//				User user = new User(signUpRequest.getUserName(), signUpRequest.getEmail(),
//				encoder.encode(signUpRequest.getPassword()));

			return userRepository.save(user);
		
		 

//		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		}
		catch (Exception e) {
			 throw new NotFoundException(e.getMessage());
		}
	}
	

	@PostMapping("/socialLogin")
	public ResponseEntity<?> socialLogin (@RequestBody ResponseGoogle ResponseGoogle) {
		
		User userAccount = userRepository.findByEmail(ResponseGoogle.getEmail());	
		
		if(userAccount!=null) {
			
			String jwt = jwtUtils.generateTokenSocial(ResponseGoogle.getUserName(), ResponseGoogle.getEmail());
			
			return ResponseEntity.ok(new JwtResponse(jwt, 
					userAccount.getId(), 
					userAccount.getUserName(), 
					userAccount.getEmail(),
					userAccount.getRole()
		            ));
			
			
			
		}else {
			RequestUser user = new RequestUser();
			
			user.setEmail(ResponseGoogle.getEmail());
			user.setUserName(ResponseGoogle.getUserName());
			
			user.setPassword(encoder.encode(ResponseGoogle.getPassword()));
			
			user.setRole("user");
			
			 User registerUser = registerUser(user);
			 String jwt = jwtUtils.generateTokenSocial(ResponseGoogle.getUserName(), ResponseGoogle.getEmail());
			
			 
			 
			 return ResponseEntity.ok(new JwtResponse(jwt, 
					 registerUser.getId(), 
						registerUser.getUserName(), 
						registerUser.getEmail(),
						registerUser.getRole()
			            ));
		}
		
//		return null;
		
		
	}
	

}
