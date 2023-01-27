package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
			return ResponseEntity.ok(u);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
