package com.housingboard.model;
/**
 * @author nitish
 */
public class UserAdInterest {
	
	private int id;
	private String title;
	private String imageUrl;
	
	//ToDo: to be deleted
	private int userId;
	
	private boolean isAvailable;
	private String description;
	private String community;
	
	private String preferences;
	private String leaseType;
	private boolean sharing;
	private String apartmentType;
	
	private int interestId;
	private int postedUserId;
	private int adId;
	private int interestUserId;
	
	private boolean isApproved;
	private boolean isPending;
	private String statusOfInterest;
	
	public String getStatusOfInterest() {
		return statusOfInterest;
	}
	public void setStatusOfInterest(String statusOfInterest) {
		this.statusOfInterest = statusOfInterest;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCommunity() {
		return community;
	}
	public void setCommunity(String community) {
		this.community = community;
	}
	public String getPreferences() {
		return preferences;
	}
	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}
	public String getLeaseType() {
		return leaseType;
	}
	public void setLeaseType(String leaseType) {
		this.leaseType = leaseType;
	}
	public boolean isSharing() {
		return sharing;
	}
	public void setSharing(boolean sharing) {
		this.sharing = sharing;
	}
	public String getApartmentType() {
		return apartmentType;
	}
	public void setApartmentType(String apartmentType) {
		this.apartmentType = apartmentType;
	}

	
	public int getInterestId() {
		return interestId;
	}
	public void setInterestId(int interestId) {
		this.interestId = interestId;
	}
	public int getPostedUserId() {
		return postedUserId;
	}
	public void setPostedUserId(int postedUserId) {
		this.postedUserId = postedUserId;
	}
	public int getAdId() {
		return adId;
	}
	public void setAdId(int adId) {
		this.adId = adId;
	}
	public int getInterestUserId() {
		return interestUserId;
	}
	public void setInterestUserId(int interestUserId) {
		this.interestUserId = interestUserId;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	public boolean isPending() {
		return isPending;
	}
	public void setPending(boolean isPending) {
		this.isPending = isPending;
	}
	
	
}
