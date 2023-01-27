package com.app.service;

import java.util.Optional;

import com.app.pojos.User;

public interface IUserService {
	User createNewUser(User u);
	Optional<User> getUserById(Integer id);
}
