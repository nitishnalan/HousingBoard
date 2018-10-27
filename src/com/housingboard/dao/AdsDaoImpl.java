package com.housingboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.housingboard.model.Ads;
import com.housingboard.model.Filters;
import com.housingboard.model.SearchFilters;


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
				ps = conn.prepareStatement("Select * from housingboard.Ads where ads_title like '%" + searchField +""
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

	@Override
	public List<Ads> getSearchResultsByPage(String searchFieldController, int pageid, int total) {
		String searchField = searchFieldController;
		List<Ads> listOfAds = new ArrayList<>();
		String sql = "select * from Ads";
		 // String sql="select * from product_details";
		/*  if(searchField.equals("")){
			//  sql = sql + " WHERE id like'%"+searchField+"%' OR product_name like '%"+searchField+"%'";
		  }
		  else*/ 
		  if(searchField.equals("*")) {
			 // sql = sql + " WHERE id like'%"+searchField+"%' OR product_name like '%"+searchField+"%'";
			  sql = "select * from Ads";
		  }else if(!searchField.equals("")){
			  sql = sql + " WHERE ads_title like '%"+searchField+"%' OR ads_description like '%"+searchField+"%'";
		  }
		  sql = sql + " limit "+(pageid-1)+","+total;  
		
		  System.out.println("SQL inside getResults page : " + sql);

			try {
				conn = db.getConnection();
				//ToDO: Make changes for better search Results
//				ps = conn.prepareStatement("Select * from Ads where ads_title like '%" + searchField +""
//						+ "%' OR  ads_description like '%" +searchField+ "%';");
				
				ps = conn.prepareStatement(sql);
				
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

	@Override
	public boolean createNewAd(Ads adModel) {
		// TODO Auto-generated method stub
		try {
			conn = db.getConnection();
//			ps = conn.prepareStatement("insert into ads (title, imageUrl, userId, isAvailable, description, community)"
//					+ " values ('"+adModel.getTitle()+"', '"+adModel.getImageUrl()+"',"++")");
					
					
			ps = conn.prepareStatement("insert into ads (ads_title, ads_image_url,ads_user_id,ads_is_available, ads_description,ads_community) "
					+ "values ('"+adModel.getTitle()+"' , '"+adModel.getImageUrl()+"' ,"+adModel.getUserId()+","+(adModel.isAvailable() ? 1 :0)+",'"+adModel.getDescription()+"','"+adModel.getCommunity()+"')");
			
//			ps.setString(1, adModel.getTitle());
//			ps.setString(2, adModel.getImageUrl());
//			ps.setInt(3, adModel.getUserId());
//			ps.setBoolean(4, (adModel.isAvailable() ? 1 :0));
//			ps.setString(5, adModel.getDescription());
//			ps.setString(6, adModel.getCommunity());
			System.out.println("Connection: "+ps);
			ps.executeUpdate();
			conn.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Ads> getSearchResultsByPageByFilter(String searchKey, int pageid, int total,
			Filters filterObj) {
		String searchField = searchKey;
		List<Ads> listOfAds = new ArrayList<>();
		String sql = "select * from Ads";
		
		String filterApplied = getFilterApplied(filterObj);
		  if(searchField.equals("*")) {
			 // sql = sql + " WHERE id like'%"+searchField+"%' OR product_name like '%"+searchField+"%'";
			  sql = "select * from Ads";
		  }else if(!searchField.equals("")){
			  sql = sql + " WHERE ads_title like '%"+searchField+"%' OR ads_description like '%"+searchField+"%'";
		  }
		  
		  if(filterApplied != "") {
			  sql += " AND " + filterApplied;
		  }
		  
		  sql = sql + " limit "+(pageid-1)+","+total;  
		
		  System.out.println("SQL inside getResults page : " + sql);

			try {
				conn = db.getConnection();
				//ToDO: Make changes for better search Results
//				ps = conn.prepareStatement("Select * from Ads where ads_title like '%" + searchField +""
//						+ "%' OR  ads_description like '%" +searchField+ "%';");
				
				ps = conn.prepareStatement(sql);
				
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

	private String getFilterApplied(Filters filterObj) {
		
		StringBuilder filterSql = new StringBuilder("");
		boolean initFilterSet = false;
		String tempSql = "";
		final String andStr = "AND";
		
		//filter for leasing type
		if(filterObj.getAdsLeasingType()!=null) {
			initFilterSet = true;
			tempSql = "ads_leasing_type IN (" + filterObj.getAdsLeasingType() + ")";
			filterSql.append("ads_leasing_type IN ('" + filterObj.getAdsLeasingType() + "')");
		}
		
		
		//filter for preferences
		if(filterObj.getAdsPreferences() != null) {
			String preferenceSql = "";
			
			for(String eachPreferences : filterObj.getAdsPreferences()) {
				if(preferenceSql == "") {
					preferenceSql = eachPreferences;
				}else {
					preferenceSql += "," + eachPreferences;
				}
			}

			if(filterSql.toString().equals("")) {
				filterSql.append("ads_preferences like ('%" + preferenceSql + "%')");
			}else
			{
				filterSql.append(" ");
				filterSql.append(andStr).append(" ").append("ads_preferences like ('%" + preferenceSql + "%')");
				
			}
		}
		
		//filter for sharing
		if(filterObj.isAdsSharing()) {
			
			if(filterSql.toString().equals("")) {
				filterSql.append("ads_sharing is false");
			}else
			{
				filterSql.append(" ");
				filterSql.append(andStr).append(" ").append("ads_sharing is false");
				
			}
			
		}
		
		//filter for apartment type
		if(filterObj.getAdsApartmentType() != null) {
			String apartmentTypeSql = "";
			
			for(String eachType : filterObj.getAdsApartmentType()) {
				if(apartmentTypeSql == "") {
					apartmentTypeSql = eachType;
				}else {
					apartmentTypeSql += "," + eachType;
				}
			}

			if(filterSql.toString().equals("")) {
				filterSql.append("ads_apartment_type_id IN (" + apartmentTypeSql + ")");
			}else
			{
				filterSql.append(" ");
				filterSql.append(andStr).append(" ").append("ads_apartment_type_id IN (" + apartmentTypeSql + ")");
				
			}
		}
		
		System.out.println("Filter SQL : " + filterSql.toString());
		
		return filterSql.toString();
	}
	
}
