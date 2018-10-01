package com.housingboard.model;
/*
 * Author: Omkar Dixit, Tushar Chemburkar
 *  */
public class Login {
	private String email_id;
	private String password;
	
	public Login(String email_id, String pass){
		this.email_id = email_id;
		this.password = pass;
	}
	public String getEmailId() {
		return email_id;
	}
	public void setEmailId(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}