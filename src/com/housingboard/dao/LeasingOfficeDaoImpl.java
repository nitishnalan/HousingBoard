package com.housingboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.housingboard.model.Login;
import com.housingboard.model.LeasingOffice;
import com.housingboard.model.Register;
import com.housingboard.model.UserModel;

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
			ps = conn.prepareStatement("Select *,count(*) as CountRow from user where user_email_id = '"+
			login.getEmailId() + "' and user_type_id = 2 and password = '" + login.getPassword() +"'");
			System.out.println("Connection: " +ps);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int rowCount = Integer.parseInt(rs.getString("CountRow"));
			
			System.out.println("rowCount : " + rs.getRow() );
			if(rowCount == 1) {
				LeasingOffice lo = new LeasingOffice();
				lo.setAddress(rs.getString("user_address"));
				lo.setCity(rs.getString("user_city"));
				lo.setCountry(rs.getString("user_country"));
				lo.setEmailId(rs.getString("user_email_id"));
				lo.setId(rs.getInt("user_id"));
				lo.setName(rs.getString("user_name"));
				lo.setPhoneNumb(rs.getString("user_phone_no"));
				//lo.setRegistrationDate(rs.getString("user_registration_date"));
				lo.setState(rs.getString("user_state"));
				lo.setUserType(rs.getInt("user_type_id"));
				lo.setZipcode(rs.getString("user_zipcode"));
				return lo;
			}else {
				System.out.println("USername password not matched");
				return null;
			}			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public boolean register(UserModel leasingOfficeObject) {
		// TODO Auto-generated method stub
		try {
			LeasingOffice lo = (LeasingOffice) leasingOfficeObject;
			conn = db.getConnection();
			ps = conn.prepareStatement(
					"insert into user (user_name, "
					+ "user_phone_no, user_address, user_email_id, password, "
					+ "user_city, user_state, user_country, user_zipcode, "
					+ "user_registration_date, user_type_id, isActive) "
					+ "values ('"+lo.getName()+"', '"+lo.getPhoneNumb()+"','"
					+lo.getAddress()+"','"+lo.getEmailId()+"','"+lo.getPassword()
					+"','"+lo.getCity()+"','"+lo.getState()+"','"+lo.getCountry()+"','"
					+lo.getZipcode()+"',NOW(),"+lo.getUserType()
					+","+(lo.isActive() ? 1 : 0)+")"
					);
			System.out.println("Connection: "+ps);
			ps.executeUpdate();
		//	System.out.println(rs);
			
			return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

	
	public boolean checkIfUserIsLeasingOffice(int userId) {
		String sql = "	SELECT count(*) as count1 FROM housingboard.user " + 
				"	where (user_id = "+userId+" AND user_type_id = 2) " + 
				"	limit 1";
		
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement(sql);
			System.out.println("Connection: " +ps);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			int isLeasingOffice = Integer.parseInt(rs.getString("count1"));
					
			if(isLeasingOffice == 1) {
				return true;
			}else {
				System.out.println("Application Warning : user is not a leasing office type");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return false;
	}

}
