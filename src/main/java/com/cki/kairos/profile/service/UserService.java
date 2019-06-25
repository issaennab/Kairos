package com.cki.kairos.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cki.kairos.profile.model.User;
import com.cki.kairos.profile.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User getUser(int userId) {
		return userRepository.findByUserId(userId);
	}

	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	
}
