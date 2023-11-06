package com.comments.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int userId;
private String commentTo;
private String commentFrom;
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getCommentTo() {
	return commentTo;
}
public void setCommentTo(String commentTo) {
	this.commentTo = commentTo;
}
public String getCommentFrom() {
	return commentFrom;
}
public void setCommentFrom(String commentFrom) {
	this.commentFrom = commentFrom;
}
	
}
