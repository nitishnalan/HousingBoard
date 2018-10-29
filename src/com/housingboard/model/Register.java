package com.housingboard.model;

/**
 * Author: Omkar Dixit, Tushar Chemburkar
 * 
 */
public class Register {
	private String email_id;
	private String password;
	private String full_name;
	private String phone_no ;
	private String address ;
	private String city ;
	private String zipcode;
	private String state ;
	private String country ;
	private String user_type ;
	public Register(String email_id, String password, String full_name, String phone_no, String address, String city,
			String zipcode, String state, String country, String user_type) {
		this.email_id = email_id;
		this.password = password;
		this.full_name = full_name;
		this.phone_no = phone_no;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
		this.country = country;
		this.user_type = user_type;
	}
	
	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
}
