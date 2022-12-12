package com.assignment14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment14.domain.User;
import com.assignment14.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;

	public User createUser(String name) {
		User user = new User();
		user.setName(name);
		return userRepo.save(user);
		
	}
}
