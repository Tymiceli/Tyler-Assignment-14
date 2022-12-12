package com.assignment14.repository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.assignment14.domain.User;

@Component
public class UserRepository {
	
	private Set<User> users = new HashSet<>(); 
			
	public User save(User user) {
		users.add(user);
		return user;
	}

}
