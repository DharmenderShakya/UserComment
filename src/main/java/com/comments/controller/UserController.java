package com.comments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.comments.entity.User;
import com.comments.repository.UserRepository;
import com.comments.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository ;
	
	  @PostMapping("/add")
	    public ResponseEntity<String> addComment(@RequestBody User user) {
	        User addedUser = userService.addUser(user);
	        if (addedUser != null) {
	            return ResponseEntity.ok("Comment added successfully");
	        } else {
	            return ResponseEntity.badRequest().body("Invalid Request");
	        }
	    }
	@GetMapping("findBy/{commentTo}")
	public User getByCommentTo(@PathVariable String commentTo) {
		return userRepository.findByCommentTo(commentTo);
	}
	
	@GetMapping("getBy/{commentFrom}")
	public User getByCommentFrom(@PathVariable String commentFrom) {
		return userRepository.findByCommentFrom(commentFrom);
	}
	
}
