package com.housingboard.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.housingboard.main.CreateConfigProperties;
import com.housingboard.model.Ads;
import com.housingboard.model.UserAdInterest;

/**
 * @author nitish
 */
public class InterestDaoImpl {
	
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();

	public boolean insertUserShowsInterestForAd(Ads adDetails, int userId) {
		try {
			
			System.out.println("INSIDE insertUserShowsInterestForAd");
			
			System.out.println("adDetails.getUserId() : " + adDetails.getUserId());
			System.out.println("adDetails.getId() : " + adDetails.getId());
			System.out.println("userId : " + userId);
			conn = db.getConnection();
				
			ps = conn.prepareStatement("insert into housingboard.user_ad_interests (posted_user_id, ad_id,interest_shower_id,status) "
					+ "values ('"+adDetails.getUserId()+"' , '"+adDetails.getId()+"' ,"+userId+","+1+")");
			
			System.out.println("Connection: "+ps);
			ps.executeUpdate();
			conn.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	public List<UserAdInterest> getEachUserInterest(int userId) {
//		String sql = "SELECT * FROM housingboard.ads T1, housingboard.apartment_type T2, "
//				+ "housingboard.user_ad_interests T3 WHERE T1.ads_id = T3.ad_id AND "
//				+ "T1.ads_apartment_type_id = T2.apartment_id AND ads_is_available is true "
//				+ "AND interest_shower_id ="+userId;
		
		String sql = "SELECT * FROM housingboard.ads T1, housingboard.apartment_type T2," + 
				"housingboard.user_ad_interests T3, housingboard.interest_status T4" + 
				"WHERE T1.ads_id = T3.ad_id AND" + 
				"T1.ads_apartment_type_id = T2.apartment_id AND" + 
				"ads_is_available is true AND" + 
				"T4.status_id = T3.status AND" + 
				"interest_shower_id ="+userId;
		
		List<UserAdInterest>  listUserAdInterest = new ArrayList<>();
		
		try {
			
			conn = db.getConnection();
			ps = conn.prepareStatement(sql);
			System.out.println("Connection: " +ps);
			ResultSet rs = ps.executeQuery();
						
			while(rs.next()) {
				UserAdInterest usrInterestObj = new UserAdInterest();
				
				usrInterestObj.setAdId(Integer.parseInt(rs.getString("ads_id")));
				usrInterestObj.setTitle(rs.getString("ads_title"));
				usrInterestObj.setImageUrl(rs.getString("ads_image_url"));
				usrInterestObj.setDescription(rs.getString("ads_description"));
				usrInterestObj.setCommunity(rs.getString("ads_community"));
				usrInterestObj.setLeaseType(rs.getString("ads_leasing_type"));
				usrInterestObj.setSharing(rs.getBoolean("ads_sharing"));
				usrInterestObj.setApartmentType(rs.getString("apartment_type"));
				
				String adPreferenceStr = getValuesForEachPreferences(rs.getString("ads_preferences"));
				if(adPreferenceStr.equals("")) {
					return null;
				}else {
					usrInterestObj.setPreferences(adPreferenceStr);
				}
				
				usrInterestObj.setPostedUserId(Integer.parseInt(rs.getString("posted_user_id")));
				usrInterestObj.setInterestUserId(Integer.parseInt(rs.getString("interest_shower_id")));
				usrInterestObj.setStatusOfInterest(rs.getString("status_value"));

				listUserAdInterest.add(usrInterestObj);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return listUserAdInterest;
	}
	
	private String getValuesForEachPreferences(String resultSetStr) {
		
		StringBuilder adPrefStr = new StringBuilder(""); 
		String[] tempStr = resultSetStr.split(",");
		
		try {
			Properties propFile = new Properties();
			InputStream input = null;
			String filename = "config-properties";
			input = CreateConfigProperties.class.getClassLoader().getResourceAsStream(filename);
			if(input==null){
		            System.out.println("Sorry, unable to find " + filename);
			    return null;
			}
			
			propFile.load(input);
			
			for(String s : tempStr) {
				if(adPrefStr.toString().equals("")) {
					adPrefStr.append(propFile.getProperty("preferences-"+s.trim()));
				}else {
					adPrefStr.append(",");
					adPrefStr.append(propFile.getProperty("preferences-"+s.trim()));
				}
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return adPrefStr.toString();

	}

}
