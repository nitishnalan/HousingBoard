package com.housingboard.model;
/**
 * @author nitish
 */
public class LeasingOffice extends UserModel{

	//initialize when registering the user
	public LeasingOffice(String name, String phoneNumb, String address, String emailId, String city, String state,
			String country, String zipcode, int userType, boolean isActive, String password) {
		
		super(name, phoneNumb, address, emailId, city, state, country, zipcode, userType,isActive,password);
		// TODO Auto-generated constructor stub
	}

	public LeasingOffice() {
		// TODO Auto-generated constructor stub
	}

}
