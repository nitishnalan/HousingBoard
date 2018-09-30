package com.housingboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.housingboard.model.Login;
import com.housingboard.model.LeasingOffice;
import com.housingboard.model.Register;

/**
 * @author nitish
 */
public class LeasingOfficeDaoImpl implements UserDao{

	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	@Override
	public LeasingOffice loginUser(Login login) {
		// TODO Auto-generated method stub
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement("Select * from user where user_email_id = "+
			login.getEmailId() + " and password = " + login.getPassword());
			System.out.println("Connection: " +ps);
			ResultSet rs = ps.executeQuery();
			LeasingOffice lo = new LeasingOffice();
			lo.setAddress(rs.getString("user_address"));
			lo.setCity(rs.getString("user_city"));
			lo.setCountry(rs.getString("user_country"));
			lo.setEmailId(rs.getString("user_email_id"));
			lo.setId(rs.getInt("user_id"));
			lo.setName(rs.getString("user_name"));
			lo.setPhoneNumb(rs.getString("user_phone_no"));
			lo.setRegistrationDate(rs.getString("user_registration_date"));
			lo.setState(rs.getString("user_state"));
			lo.setUserType(rs.getInt("user_type_id"));
			lo.setZipcode(rs.getString("user_zipcode"));
			
			return lo;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public boolean register(Register register) {
		// TODO Auto-generated method stub
		try {
			LeasingOffice lo = new LeasingOffice();
			conn = db.getConnection();
			ps = conn.prepareStatement(
					"insert into user (user_name, "
					+ "user_phone_no, user_address, user_email_id, password, "
					+ "user_city, user_state, user_country, user_zipcode, "
					+ "user_registration_date, user_type_id, isActive) "
					+ "values ("+lo.getName()+", "+lo.getPhoneNumb()+","
					+lo.getAddress()+","+lo.getEmailId()+","+lo.getPassword()
					+","+lo.getCity()+","+lo.getState()+","+lo.getCountry()+","
					+lo.getZipcode()+","+lo.getRegistrationDate()+","+lo.getUserType()
					+","+lo.isActive()+")"
					);
			System.out.println("Connection: "+ps);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
