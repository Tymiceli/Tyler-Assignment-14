package com.assignment14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment14.domain.User;
import com.assignment14.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;

	public void save(User user) {
		userRepo.save(user);
		
	}

	public User getUserById(Long userId) {
		User user = userRepo.findById(userId);
		
		return user;
	}

}
