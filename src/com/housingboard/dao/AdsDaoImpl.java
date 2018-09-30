package com.housingboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.housingboard.model.Ads;
import com.housingboard.dao.DbManager;


/**
 * @author nitish
 */
public class AdsDaoImpl implements AdsDao {

	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	@Override
	public List<Ads> getSearchResults(String searchField) {
		
		List<Ads> listOfAds = new ArrayList<>();
		if(searchField !="") {
			
			try {
				conn = db.getConnection();
				//ToDO: Make changes for better search Results
				ps = conn.prepareStatement("Select * from Ads where ads_title like '%" + searchField +""
						+ "%' OR  ads_description like '%" +searchField+ "%';");
				
				System.out.println("Conn : " + ps);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Ads adsModel = new Ads();
					adsModel.setId(Integer.parseInt(rs.getString("ads_id")));
					adsModel.setTitle(rs.getString("ads_title"));
					adsModel.setImageUrl(rs.getString("ads_image_url"));
					adsModel.setUserId(Integer.parseInt(rs.getString("ads_user_id")));
					adsModel.setAvailable(rs.getBoolean("ads_is_available"));
					adsModel.setDescription(rs.getString("ads_description"));
					adsModel.setCommunity(rs.getString("ads_community"));
					
					System.out.println("ADSMODEL : " + adsModel.isAvailable());
					
					listOfAds.add(adsModel);
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
			return listOfAds;
		}
		return null;
	}

}
