package com.housingboard.model;
/**
 * @author nitish
 */
public class CheckAdInterest {
	
	private int interestShowerUserId;
	private String userName;
	private String userPhoneNo;
	private String userEmailId;
	private String statusValue;
	private int ad_id;
	private int interestID;
	
	public int getInterestID() {
		return interestID;
	}
	public void setInterestID(int interestID) {
		this.interestID = interestID;
	}
	public int getAd_id() {
		return ad_id;
	}
	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
	public int getInterestShowerUserId() {
		return interestShowerUserId;
	}
	public void setInterestShowerUserId(int interestShowerUserId) {
		this.interestShowerUserId = interestShowerUserId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhoneNo() {
		return userPhoneNo;
	}
	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getStatusValue() {
		return statusValue;
	}
	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}
}
