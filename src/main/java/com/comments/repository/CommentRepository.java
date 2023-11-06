package com.comments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comments.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment,Integer>{

	 List<Comment> findByPostedByUserIdCommentTo(String CommentTo);
	 
	 List<Comment> findByPostedByUserIdCommentFrom(String CommentFrom);
	 
}
