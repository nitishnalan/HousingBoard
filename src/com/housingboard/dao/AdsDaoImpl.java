package com.housingboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.housingboard.model.Ads;
import com.housingboard.model.Filters;
import com.housingboard.model.SearchFilters;
/**
 * AbstractDAO.java
 * This DAO class provides CRUD database operations for the table book
 * in the database.
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
		  if(searchField.equals("*")) {
			  sql = "select * from Ads";
		  }else if(!searchField.equals("")){
			  sql = sql + " WHERE ads_title like '%"+searchField+"%' OR ads_description like '%"+searchField+"%'";
		  }
		  sql = sql + " limit "+(pageid-1)+","+total;  
		
		  System.out.println("SQL inside getResults page : " + sql);

			try {
				conn = db.getConnection();
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

	
	//Crud Ads
	
	//CREATE
	@Override
	public boolean insertAds(Ads adModel) {
		System.out.println("Inside insert adsdaoImpl");
		try {
			conn = db.getConnection();					
			ps = conn.prepareStatement("insert into ads (ads_title, ads_image_url,ads_user_id,ads_is_available, ads_description,ads_community,ads_preferences,ads_leasing_type,ads_sharing,ads_apartment_type_id ) "
					+ "values ('"+adModel.getTitle()+"' , '"+adModel.getImageUrl()+"' ,"+adModel.getUserId()+","+(adModel.isAvailable() ? 1 :0)+",'"+adModel.getDescription()+"','"+adModel.getCommunity()+"','"+adModel.getPreferences()+"','"+adModel.getLeasingType()+"',"+(adModel.isSharing() ? 1 :0)+",'"+adModel.getApartmentTypeID()+"')");
			System.out.println("Connection: "+ps);
			ps.executeUpdate();
			conn.close();						
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return true;
    }
    
	
	@Override
    public List<Ads> listAllAds(int userId) {
        List<Ads> ads_list = new ArrayList<>();
        try {
        	String sql = "SELECT ads_id, ads_title, ads_image_url, ads_description, ads_community  FROM ads where ads_user_id="+userId+" and ads_is_available=1;";
        	
            conn = db.getConnection();					
    		ps =   conn.prepareStatement(sql);
    		ResultSet resultSet = ps.executeQuery(sql);   		
    		System.out.println("Connection: "+ps);
    		
    		while (resultSet.next()) {
        
                Ads adsModel = new Ads();
				adsModel.setId(Integer.parseInt(resultSet.getString("ads_id")));
				adsModel.setTitle(resultSet.getString("ads_title"));
				adsModel.setImageUrl(resultSet.getString("ads_image_url"));
				adsModel.setDescription(resultSet.getString("ads_description"));
				adsModel.setCommunity(resultSet.getString("ads_community"));
				ads_list.add(adsModel);
            }
             
            resultSet.close();
            ps.close();
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
              
        return ads_list;
    }
     
	@Override
    public boolean deleteAdsFromDatabase(Ads adsModel,int adID) {
		// TODO Auto-generated method stub
		try {
			System.out.println("IN DELETE");
			conn = db.getConnection();	
			ps = conn.prepareStatement("update ads SET ads_is_available=0 where ads_id = "+adID+";");
			System.out.println("Connection: "+ps);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return true;   
    }
     
    public boolean updateAdsFromDatabase(Ads adModel, int usId) {
		// TODO Auto-generated method stub
		try {
			System.out.println("In update");
			conn = db.getConnection();
					
			ps = conn.prepareStatement("update ads SET ads_title = ?,ads_image_url=? ,ads_user_id= ? ,ads_is_available= ? , ads_description = ? ,ads_community = ?,ads_preferences = ? ,ads_leasing_type= ? ,ads_sharing= ? ,ads_apartment_type_id=? where where ads_id = "+usId);
			System.out.println("Connection: "+ps);
			ps.executeUpdate();
			conn.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false; 
    }
     
    public Ads getAd(int id){
        Ads ads = null;
        try {
            
        	
        	String sql = "SELECT ads_title, ads_image_url, ads_user_id, ads_description, ads_community, ads_preferences, ads_leasing_type, ads_sharing, ads_apartment_type_id FROM ads WHERE ads_id ="+id+"and ads_is_available=1;";

            conn = db.getConnection();
            
            ps = conn.prepareStatement(sql);
            
            ps.setInt(1, id);
             
            ResultSet resultSet = ps.executeQuery();
             
            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String imageUrl = resultSet.getString("ads_image_url");
                int userId = resultSet.getInt("ads_user_id"); 
                String description = resultSet.getString("ads_description");
                String community = resultSet.getString("ads_community");
                String preferences = resultSet.getString("ads_preferences");
                String leasingType = resultSet.getString("ads_leasing_type");
                boolean sharing = resultSet.getString("ads_sharing") != null;
                int apartmentTypeId = resultSet.getInt("ads_apartment_type_id"); 
                
                 ads = new Ads(title, imageUrl, userId,  description,
     	    			community, preferences, leasingType, sharing, apartmentTypeId);
            }
            resultSet.close();
            ps.close();
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
         
        return ads;
    }
	
	

	@Override
	public List<Ads> getSearchResultsByPageByFilter(String searchKey, int pageid, int total,
			Filters filterObj) {
		String searchField = searchKey;
		List<Ads> listOfAds = new ArrayList<>();
		String sql = "select * from Ads";
		
		String filterApplied = getFilterApplied(filterObj);
		  if(searchField.equals("*")) {
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
