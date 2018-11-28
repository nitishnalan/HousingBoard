package com.housingboard.model;
/**
 * @author nitish
 */
public class Member extends UserModel{

	public Member(String name, String phoneNumb, String address, String emailId, String city, String state,
			String country, String zipcode, int userType, boolean isActive, String password, int id, int pageFlag) {
		
		super(name, phoneNumb, address, emailId, city, state, country, zipcode, userType, isActive, password, id, pageFlag);
		// TODO Auto-generated constructor stub
	}

	//ToDO Prakhar
	public Member(String name, String phoneNumb, String address, String emailId, String city, String state,
			String country, String zipcode, int id) {
		super(name, phoneNumb, address, emailId, city, state, country, zipcode,id);
	}
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String userFullName, String userPhoneNo, String userAddress, String userEmail, String userCity,
			String userState, String userCountry, String userZipCode, int userType, boolean b, String userPassword,
			int i) {
		// TODO Auto-generated constructor stub
	}
	
}
