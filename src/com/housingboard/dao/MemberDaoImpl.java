package com.housingboard.dao;

import com.housingboard.model.LeasingOffice;
import com.housingboard.model.Login;
import com.housingboard.model.Member;
import com.housingboard.model.Register;
import com.housingboard.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author nitish
 */
public class MemberDaoImpl implements UserDao{

	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	@Override
	public Member loginUser(Login login) {
		// TODO Auto-generated method stub
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement("Select *,count(*) as CountRow from user where user_email_id = '"+
					login.getEmailId() + "' and password = '" + login.getPassword() +"'");
			System.out.println("Connection: " +ps);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			int rowCount = Integer.parseInt(rs.getString("CountRow"));
			
			System.out.println("rowCount : " + rs.getRow() );
			
			if(rowCount == 1) {
				Member member = new Member();
				member.setAddress(rs.getString("user_address"));
				member.setCity(rs.getString("user_city"));
				member.setCountry(rs.getString("user_country"));
				member.setEmailId(rs.getString("user_email_id"));
				member.setId(rs.getInt("user_id"));
				member.setName(rs.getString("user_name"));
				member.setPhoneNumb(rs.getString("user_phone_no"));
				//member.setRegistrationDate(rs.getString("user_registration_date"));
				member.setState(rs.getString("user_state"));
				member.setUserType(rs.getInt("user_type_id"));
				member.setZipcode(rs.getString("user_zipcode"));
				
				return member;
			}else {
				System.out.println("USERNAME and Password does not match!");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public boolean register(UserModel memberReigster) {
		// TODO Auto-generated method stub
		try {
			Member memberObject = (Member) memberReigster;
			conn = db.getConnection();
			ps = conn.prepareStatement(
					"insert into user (user_name, "
					+ "user_phone_no, user_address, user_email_id, password, "
					+ "user_city, user_state, user_country, user_zipcode, "
					+ "user_registration_date, user_type_id, isActive) "
					+ "values ('"+memberObject.getName()+"', '"+memberObject.getPhoneNumb()+"','"
					+memberObject.getAddress()+"','"+memberObject.getEmailId()+"','"+memberObject.getPassword()
					+"','"+memberObject.getCity()+"','"+memberObject.getState()+"','"+memberObject.getCountry()+"','"
					+memberObject.getZipcode()+"',NOW(),"+memberObject.getUserType() +","+ (memberObject.isActive() ? 1 : 0)+")"
					);
			System.out.println("Connection: "+ps);
			ps.executeUpdate();
			conn.close();			
			return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
