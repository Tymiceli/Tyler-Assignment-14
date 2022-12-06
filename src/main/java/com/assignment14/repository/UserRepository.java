package com.assignment14.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.assignment14.domain.User;

@Repository
public class UserRepository {
	
	private HashMap<Long, User> users = new HashMap<Long, User>();

	public void save(User user) {
		users.put(user.getId(), user);
	}

	public User findById(Long userId) {
		User user = users.get(userId);
		return user;
	}

}
