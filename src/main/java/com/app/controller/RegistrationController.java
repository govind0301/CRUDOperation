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

import com.app.pojos.Users;
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
	public ResponseEntity<?> SaveUserDetails(@RequestBody Users u)
	{
		try {
			System.out.println("User in "+ u.toString());
			Users userController = service.createNewUser(u);
			System.out.println("in Controller"
					+ " "+userController);
			return new ResponseEntity<>(userController,HttpStatus.CREATED);
		}
		catch (Exception e) {
			System.out.println("exception "+ e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/details/{userId}")
	public ResponseEntity<?> getUserDetailById(@PathVariable Integer userId)
	{
		Optional<Users> user = service.getUserById(userId);
		if(user.isPresent())
		{
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/details")
	public ResponseEntity<?> getAllUser()
	{
		try {
			return new ResponseEntity<>(service.getAllUser(),HttpStatus.OK);
		}
		catch(Exception ex)
		{
			System.out.println("exeception in "+ex);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/detailsByName/{name}")
	public ResponseEntity<?> getUserByName(@PathVariable String name){
		try {
			return new ResponseEntity<>(service.getUserByName(name),HttpStatus.OK);
		}
		catch(Exception ex)
		{
			System.out.println("exception in "+ex);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/detailsByLastName/{lastName}")
	public ResponseEntity<?> getUserByLastName(@PathVariable String lastName)
	{
		try
		{
			return new ResponseEntity<>(service.getUserByLastNameStartingWith(lastName),HttpStatus.OK);
		}
		catch(Exception ex)
		{
			System.out.println("exception in"+ ex);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
