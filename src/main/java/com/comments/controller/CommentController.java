package com.comments.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.comments.entity.Comment;
import com.comments.entity.User;
import com.comments.repository.UserRepository;
import com.comments.service.CommentService;
import com.comments.service.UserService;

@RestController
@RequestMapping("/api/comments")
public class CommentController{
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserRepository userRepository ;
	
    @PostMapping("/add")
    public ResponseEntity<String> addComment(@RequestBody Comment comment) {
//    	if(comment.getPostedByUserId().getCommentFrom().matches(".*\\d.*") || comment.getPostedByUserId().getCommentFrom()==null || comment.getPostedByUserId().getCommentFrom()=="" || comment.getPostedByUserId().getCommentTo().matches(".*[!@#$%^&*()-_+=\\[\\]{}|;:'\",.<>/?].*")) {
//    		return ResponseEntity.badRequest().body("the user name may be contains numbers or it is empty or it is blank");
//    	}
    	if(comment.getPostedByUserId().getCommentFrom().matches(".*\\d.*")) {
    		return ResponseEntity.badRequest().body("user should not be contain numbers");
    	}
    	if(comment.getPostedByUserId().getCommentFrom()==null || comment.getPostedByUserId().getCommentFrom()=="") {
    	    return ResponseEntity.badRequest().body("user should not be blank or empty");
    	    	}
    	
    	if(comment.getPostedByUserId().getCommentFrom().matches(".*[!@#$%^&*()-_+=\\[\\]{}|;:'\",.<>/?].*")) {
    	    return ResponseEntity.badRequest().body("user should not contain any special character or any symbol");
    	    	}
    	
//    	if(comment.getPostedByUserId().getCommentTo().matches(".*[!@#$%^&*()-_+=\\[\\]{}|;:'\",.<>/?].*") || comment.getPostedByUserId().getCommentTo()==null || comment.getPostedByUserId().getCommentTo()=="" || comment.getPostedByUserId().getCommentTo().matches(".*\\d.*")) {
//    		
//    		return ResponseEntity.badRequest().body("the user name may be contains special characters or symbols or it is empty or it is blank");
//    		
//    	}
    	
    	if(comment.getPostedByUserId().getCommentTo().matches(".*\\d.*")) {
    		return ResponseEntity.badRequest().body("user should not be contain numbers");
    	}
    	if(comment.getPostedByUserId().getCommentTo()==null || comment.getPostedByUserId().getCommentTo()=="") {
    	    return ResponseEntity.badRequest().body("user should not be blank or empty");
    	    	}
    	
    	if(comment.getPostedByUserId().getCommentTo().matches(".*[!@#$%^&*()-_+=\\[\\]{}|;:'\",.<>/?].*")) {
    	    return ResponseEntity.badRequest().body("user should not contain any special character or any symbol");
    	    	}
    	
    	
    	
    	
    	if(userRepository.findByCommentFrom(comment.getPostedByUserId().getCommentFrom())!=null) {
    		comment.setPostedByUserId(userRepository.findByCommentFrom(comment.getPostedByUserId().getCommentFrom()));
    		return ResponseEntity.ok(" the user whom commented was found in the database then user is not add to he database but commnet is added");
    	}
    	
    	Comment addedComment=null;
    	
//    	User user=new User();
//    			user.setCommentTo(comment.getPostedByUserId().getCommentTo());
//    	userService.addUser(user);
    	if(userRepository.findByCommentFrom(comment.getPostedByUserId().getCommentFrom())==null) {
    		addedComment= commentService.addComment(comment);
    	}
        
        if (addedComment != null) {
            return ResponseEntity.ok("Comment added successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid Request");
        }
    }

    @GetMapping("/getTo/{commentTo}")
    public ResponseEntity<List<Comment>> getComments(@PathVariable String commentTo) {
        List<Comment> comments = commentService.getCommentsByUserIdCommnetTo(commentTo);
        return ResponseEntity.ok(comments);
    }
    
    
    @GetMapping("/getFrom/{commentFrom}")
    public ResponseEntity<List<Comment>> getCommentFrom(@PathVariable String commentFrom) {
        List<Comment> comments = commentService.getCommentsByUserIdCommnetFrom(commentFrom);
        return ResponseEntity.ok(comments);
    }
}
