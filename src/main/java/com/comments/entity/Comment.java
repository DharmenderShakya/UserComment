package com.comments.entity;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity	
public class Comment {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int commentId;
private String message;
private String commentDate;
@ManyToOne(cascade = CascadeType.PERSIST)
private User postedByUserId;
public int getCommentId() {
	return commentId;
}
public void setCommentId(int commentId) {
	this.commentId = commentId;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

public User getPostedByUserId() {
	return postedByUserId;
}
public void setPostedByUserId(User postedByUserId) {
	this.postedByUserId = postedByUserId;
}
public String getCommentDate() {
	return commentDate;
}
public void setCommentDate(String commentDate) {
	this.commentDate = commentDate;
}


}
