package com.comments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comments.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByCommentTo(String commentTo);
	User findByCommentFrom(String commentFrom);
	void deleteByCommentFrom(String commentFrom);
}
