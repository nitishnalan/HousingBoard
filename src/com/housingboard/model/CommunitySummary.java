package com.housingboard.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nitish
 */
public class CommunitySummary {
	
	private int id;
	private String name;
	private String phoneNo;
	private String address;
	private String emailId;
	private String city;
	private String state;
	private String country;
	private String zip;
	private String imageUrl;
	private String pageDescription;
	private List<Review> reviewsCommunity;
	
	
	public String getPageDescription() {
		return pageDescription;
	}
	public void setPageDescription(String pageDescription) {
		this.pageDescription = pageDescription;
	}
	

	
	public List<Review> getReviewsCommunity() {
		return reviewsCommunity;
	}
	public void setReviewsCommunity(List<Review> reviewsCommunity) {
		this.reviewsCommunity = reviewsCommunity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
