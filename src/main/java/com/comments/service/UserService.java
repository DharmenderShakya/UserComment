package com.comments.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comments.entity.User;
import com.comments.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	  public User addUser(User user) {
	        // Implement user validation logic
	        return userRepository.save(user);
	    }
}
