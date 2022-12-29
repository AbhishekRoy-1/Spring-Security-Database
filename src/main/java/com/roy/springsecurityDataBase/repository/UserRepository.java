package com.roy.springsecurityDataBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roy.springsecurityDataBase.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String username);
	

}
