package com.housingboard.model;
/**
 * @author nitish
 */
public class Ads {
	
	private int id;
	private String title;
	private String imageUrl;
	private int userId;
	private boolean isAvailable;
	private String description;
	private String community;
	
	private String preferences;
	private String leaseType;
	private boolean sharing;
	private String apartmentType;
	private String postedUserType;
	
	public String getPostedUserType() {
		return postedUserType;
	}


	public void setPostedUserType(String postedUserType) {
		this.postedUserType = postedUserType;
	}


	public Ads(String title, String imageUrl, int userId, boolean isAvailable, String description,
			String community) {
		super();
		//this.id = id;
		this.title = title;
		this.imageUrl = imageUrl;
		this.userId = userId;
		this.isAvailable = isAvailable;
		this.description = description;
		this.community = community;
	}
	
	
	public Ads() {
		// TODO Auto-generated constructor stub
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	
}
