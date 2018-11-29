package com.housingboard.dao;

import com.housingboard.model.Ads;
import com.housingboard.model.LeasingOffice;
import com.housingboard.model.Login;
import com.housingboard.model.Member;
import com.housingboard.model.Register;
import com.housingboard.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nitish
 */
public class MemberDaoImpl implements UserDao{
	static int userid;
	static Connection conn;
	static Connection con;
	static PreparedStatement ps,pss;
	DbManager db = new DbManager();
	
	@Override
	public Member loginUser(Login login) {
		// TODO Auto-generated method stub
		try {
			conn = db.getConnection();

//			ps = conn.prepareStatement("Select *,count(*) as CountRow from user where user_email_id = '"+
//					login.getEmailId() + "' and user_type_id = 1 and password = '" + login.getPassword() +"'");
			ps = conn.prepareStatement(
					"SELECT user_id,user_name,user_email_id,user_phone_no,user_address,user_city,user_state,user_country,user_zipcode, user_type_id " + 
					"FROM user " + 
					"WHERE user_email_id='" + login.getEmailId()  +"' AND password='"  + login.getPassword() 
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
				userid = rs.getInt("user_id");
				member.setName(rs.getString("user_name"));
				member.setPhoneNumb(rs.getString("user_phone_no"));
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
						
			return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	@Override
	public boolean updateMember(UserModel memberReigster)
	{
		boolean rowUpdated = false;
		conn = db.getConnection();
		//con = db.getConnection();
		System.out.println("The data is" + memberReigster.getName());
		System.out.println("The 2nd data is" + memberReigster.getCity());
		try {
			ps = conn.prepareStatement("update user set user_name=?, user_address=?, user_phone_no=?, user_city=?, user_state=?,user_country=?,user_zipcode = ? where user_id = ?");
			ps.setString(1,memberReigster.getName());
			ps.setString(2, memberReigster.getAddress());
			ps.setString(3, memberReigster.getPhoneNumb());
			ps.setString(4, memberReigster.getCity());
			ps.setString(5, memberReigster.getState());
			ps.setString(6, memberReigster.getCountry());
			ps.setString(7, memberReigster.getZipcode());
			ps.setInt(8, userid);
			rowUpdated = ps.executeUpdate() > 0;
			ps.close();
			System.out.println("Id is"+ userid );
			System.out.println("in member dao");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowUpdated;
	}
	
	@Override
	public UserModel getRecordByName(String name)
	{  
		UserModel member=null;  
	    try{  
	        conn = db.getConnection();  
	        PreparedStatement ps=conn.prepareStatement("select * from user where user_id=?");  
	        ps.setString(1,name);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){   
				member.setAddress(rs.getString("user_address"));
				member.setCity(rs.getString("user_city"));
				member.setCountry(rs.getString("user_country"));
				member.setEmailId(rs.getString("user_email_id"));
				member.setId(rs.getInt("user_id"));
				member.setName(rs.getString("user_name"));
				member.setPhoneNumb(rs.getString("user_phone_no"));
				member.setState(rs.getString("user_state"));
				member.setUserType(rs.getInt("user_type_id"));
				member.setZipcode(rs.getString("user_zipcode"));
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return member;  
	}  
	
	@Override
    public List<UserModel> dataretrieve(int id) {
        List<UserModel> userdata = new ArrayList<>();
        try {
        	String sql = "SELECT * FROM user where user_id="+id+" limit 1";
        	
            conn = db.getConnection();					
    		ps =   conn.prepareStatement(sql);
    		ResultSet resultSet = ps.executeQuery(sql);
    		
    		System.out.println("Connection: "+ps);
    		
    		while (resultSet.next()) {          
                UserModel data = new UserModel();
                data.setEmailId(resultSet.getString("user_email_id"));
                data.setName(resultSet.getString("user_name"));
                data.setAddress(resultSet.getString("user_address"));
                data.setPhoneNumb(resultSet.getString("user_phone_no"));
				data.setPassword(resultSet.getString("password"));
				data.setCity(resultSet.getString("user_city"));
				data.setState(resultSet.getString("user_state"));
				data.setCountry(resultSet.getString("user_country"));
				data.setZipcode(resultSet.getString("user_zipcode"));
               
                 userdata.add(data);
            }
             
            resultSet.close();
            ps.close();
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
              
        return userdata;
    }

	@Override
	 public boolean createPage(String description, String url,int id) {
		// TODO Auto-generated method stub
		return true;
	}

	public UserModel retrieveData(int userId) {
		UserModel data = new UserModel();
		try {
        	String sql = "SELECT * FROM user where user_id="+userId+" limit 1";
        	
            conn = db.getConnection();					
    		ps =   conn.prepareStatement(sql);
    		ResultSet resultSet = ps.executeQuery(sql);
    		
    		System.out.println("Connection: "+ps);
    		
    		while (resultSet.next()) {          
                
                data.setEmailId(resultSet.getString("user_email_id"));
                data.setName(resultSet.getString("user_name"));
                data.setAddress(resultSet.getString("user_address"));
                data.setPhoneNumb(resultSet.getString("user_phone_no"));
				data.setPassword(resultSet.getString("password"));
				data.setCity(resultSet.getString("user_city"));
				data.setState(resultSet.getString("user_state"));
				data.setCountry(resultSet.getString("user_country"));
				data.setZipcode(resultSet.getString("user_zipcode"));
               
            }
             
            resultSet.close();
            ps.close();
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
              
        return data;
	}
	
}
