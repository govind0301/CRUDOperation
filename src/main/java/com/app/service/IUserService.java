package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.User;

public interface IUserService {
	User createNewUser(User u);
	Optional<User> getUserById(Integer id);
	List<User> getAllUser();
	List<User> getUserByName(String name);
	List<User> getUserByLastNameStartingWith(String name);
}
