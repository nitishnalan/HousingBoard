package com.housingboard.model;
/**
 * @author nitish
 */
public class Review {
	
	private int id;
	private int targetUserId;
	private int reviewerUserId;
	private String description;
	private String userName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTargetUserId() {
		return targetUserId;
	}
	public void setTargetUserId(int targetUserId) {
		this.targetUserId = targetUserId;
	}
	public int getReviewerUserId() {
		return reviewerUserId;
	}
	public void setReviewerUserId(int reviewerUserId) {
		this.reviewerUserId = reviewerUserId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
