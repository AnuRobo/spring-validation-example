package com.springvalidation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springvalidation.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByuserId(int id);
	
}
