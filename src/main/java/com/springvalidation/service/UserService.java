package com.springvalidation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springvalidation.dto.UserRequest;
import com.springvalidation.entity.User;
import com.springvalidation.exception.UserNotFoundException;
import com.springvalidation.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public User saveUser(UserRequest userRequest) {
		User user = User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(),
				userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
		return repository.save(user);
	}

	public List<User> getAllUsers() {
		return repository.findAll();
	}

	public User getUser(int id) throws UserNotFoundException {
		User user = repository.findByuserId(id);
		if(user==null) {
			throw new UserNotFoundException("User not found with particular id - "+ id);
		}else {
			return user;
		}
	}
}
