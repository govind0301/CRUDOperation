package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Address;
import com.app.pojos.User;

import com.app.dao.UserRepository;
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	public UserRepository repo;
	
	@Override
	public User createNewUser(User u) {
		Address address = null;
		List<Address> addr = u.getAddress();
		for(Address a : addr)
		{
			address = a;
		}
		System.out.println("address" + address);
		User user  = repo.save(u);	
		System.out.println("in service "+user);
		return user;
	}

	@Override
	public Optional<User> getUserById(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<User> getAllUser() {
		return repo.findAll();
	}

	@Override
	public List<User> getUserByName(String name) {
		return repo.findByFirstName(name);
	}

	@Override
	public List<User> getUserByLastNameStartingWith(String name) {
		return repo.findByLastNameStartingWith(name);
	}
	
	
	
	
}
