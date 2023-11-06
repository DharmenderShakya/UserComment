package com.comments.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comments.entity.Comment;
import com.comments.repository.CommentRepository;

import jakarta.transaction.Transactional;

@Service
public class CommentService{
	@Autowired
	private CommentRepository commentRepository;
	
	@Transactional
    public Comment addComment(Comment comment) {
    	comment.setCommentDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("ghjklghj"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        
        return commentRepository.save(comment);
    }
    
    @Transactional
    public List<Comment> getCommentsByUserIdCommnetTo(String commnetTo) {
        return commentRepository.findByPostedByUserIdCommentTo(commnetTo);
    }
    
    @Transactional
    public List<Comment> getCommentsByUserIdCommnetFrom(String commnetTo) {
        return commentRepository.findByPostedByUserIdCommentFrom(commnetTo);
    }
	
}
