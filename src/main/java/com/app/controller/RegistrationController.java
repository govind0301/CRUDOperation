package com.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/user")
public class RegistrationController {
	@Autowired
	public IUserService service;
	public RegistrationController()
	{
		System.out.println("in Registration Controller");
	}
	
	@PostMapping("/registration")
	public ResponseEntity<?> SaveUserDetails(@RequestBody User u)
	{
		try {
			System.out.println("User in "+ u.toString());
			User userController = service.createNewUser(u);
			System.out.println("in Controller"
					+ " "+userController);
			return new ResponseEntity<>(userController,HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/details/{userId}")
	public ResponseEntity<?> getUserDetailById(@PathVariable Integer userId)
	{
		Optional<User> user = service.getUserById(userId);
		if(user.isPresent())
		{
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
