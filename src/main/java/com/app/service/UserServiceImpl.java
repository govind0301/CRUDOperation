package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Address;
import com.app.pojos.Users;

import com.app.dao.UserRepository;
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	public UserRepository repo;
	
	@Override
	public Users createNewUser(Users u) {
		Address address = null;
		List<Address> addr = u.getAddress();
		for(Address a : addr)
		{
			address = a;
		}
		System.out.println("address" + address);
		Users user  = repo.save(u);	
		System.out.println("in service "+user);
		return user;
	}

	@Override
	public Optional<Users> getUserById(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<Users> getAllUser() {
		return repo.findAll();
	}

	@Override
	public List<Users> getUserByName(String name) {
		return repo.findByFirstName(name);
	}

	@Override
	public List<Users> getUserByLastNameStartingWith(String name) {
		return repo.findByLastNameStartingWith(name);
	}
	
	
	
	
}
