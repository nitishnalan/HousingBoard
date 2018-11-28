package com.housingboard.model;

public class UserModel {
	
	private int id;
	private String name;
	private String phoneNumb;
	private String address;
	private String emailId;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	private String registrationDate;	
	private int userType;
	private boolean isActive;
	private String password;
	private int pageFlag;
	
	public UserModel(String name, String phoneNumb, String address, String emailId, String city, String state,
			String country, String zipcode, int userType, boolean isActive, String password, int id, int pageFlag) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumb = phoneNumb;
		this.address = address;
		this.emailId = emailId;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		//this.registrationDate = registrationDate;
		this.userType = userType;
		this.isActive = isActive;
		this.password = password;
		this.pageFlag=pageFlag;
	}
	
	
	
	public UserModel(String name, String phoneNumb, String address, String emailId, 
			String city, String state, String country, String zipcode, int id) {
		super();
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.phoneNumb = phoneNumb;
		this.address = address;
		this.emailId = emailId;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPageFlag() {
		return pageFlag;
	}
	public void setPageFlag(int pageFlag) {
		this.pageFlag = pageFlag;
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
	public String getPhoneNumb() {
		return phoneNumb;
	}
	public void setPhoneNumb(String phoneNumb) {
		this.phoneNumb = phoneNumb;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
