package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	List<Users> findByFirstName(String name);
	List<Users> findByLastNameStartingWith(String name);
}
