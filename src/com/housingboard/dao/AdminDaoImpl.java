package com.housingboard.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.housingboard.model.Ads;
import com.housingboard.model.Login;
import com.housingboard.model.Member;
import com.housingboard.model.UserModel;


public class AdminDaoImpl implements AdminDao{
	
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();

	@Override
	public boolean deleteUser(int usId) {
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement("update user set isActive = FALSE where user_id="+usId);
			ps.executeUpdate();	
			conn.close();
			return true;
		// TODO Auto-generated method stub
	}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;	
	}
	@Override
	public List<UserModel> AdminlistAllUsers() {
        List<UserModel> userlist = new ArrayList<>();
        try {
        	String sql = "SELECT * FROM user where isActive IS TRUE";
        	
            conn = db.getConnection();					
    		ps =   conn.prepareStatement(sql);
    		ResultSet resultSet = ps.executeQuery(sql);
    		
    		System.out.println("Connection: "+ps);
    		
    		while (resultSet.next()) {          
                UserModel user = new UserModel();
				user.setId(Integer.parseInt(resultSet.getString("user_id")));
				user.setName(resultSet.getString("user_name"));
				user.setEmailId(resultSet.getString("user_email_id"));
				user.setPhoneNumb(resultSet.getString("user_phone_no"));
				user.setActive(resultSet.getBoolean("isActive"));
                 userlist.add(user);
            }
             
            resultSet.close();
            ps.close();
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
              
        return userlist;
    }
	@Override
	public Member loginUser(Login loginModel) {
		// TODO Auto-generated method stub
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement(
					"SELECT user_id,user_name,user_email_id,user_phone_no,user_address,user_city,user_state,user_country,user_zipcode " + 
					"FROM user " + 
					"WHERE user_email_id='" + loginModel.getEmailId()  +"' AND user_type_id='"+ 3 +"' AND password='"  + loginModel.getPassword() 
					+ "' AND isActive=1 LIMIT 1;");
			
			
			System.out.println("Connection: " +ps);
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			int rowCount = rs.getRow();
			
			
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
				member.setState(rs.getString("user_state"));
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

	
}
