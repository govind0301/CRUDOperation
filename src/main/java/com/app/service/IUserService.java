package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Users;

public interface IUserService {
	Users createNewUser(Users u);
	Optional<Users> getUserById(Integer id);
	List<Users> getAllUser();
	List<Users> getUserByName(String name);
	List<Users> getUserByLastNameStartingWith(String name);
}
