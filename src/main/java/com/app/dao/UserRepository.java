package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByFirstName(String name);
	List<User> findByLastNameStartingWith(String name);
}
