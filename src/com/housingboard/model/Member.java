package com.housingboard.model;
/**
 * @author nitish
 */
public class Member extends UserModel{

	public Member(String name, String phoneNumb, String address, String emailId, String city, String state,
			String country, String zipcode, int userType, boolean isActive, String password) {
		
		super(name, phoneNumb, address, emailId, city, state, country, zipcode, userType, isActive, password);
		// TODO Auto-generated constructor stub
	}

	public Member() {
		// TODO Auto-generated constructor stub
	}
	
}
