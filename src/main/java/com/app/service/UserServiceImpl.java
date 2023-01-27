package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.User;

import com.app.dao.UserRepository;
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	public UserRepository repo;
	
	@Override
	public User createNewUser(User u) {
		User user  = repo.save(u);	
		System.out.println("in service "+user);
		return user;
	}

	@Override
	public Optional<User> getUserById(Integer id) {
		return repo.findById(id);
	}

	
}
