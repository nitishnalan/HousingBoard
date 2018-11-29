package com.housingboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.housingboard.model.CommunitySummary;
import com.housingboard.model.Review;

/**
 * @author nitish
 */
public class CommunitySummaryDaoImpl {

	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	public CommunitySummary getCommunitySummaryDetails(int communityID) {
		
		ReviewDaoImpl reviewDaoObj = new ReviewDaoImpl();
		List<Review> reviewList = new ArrayList<Review>(); 
		reviewList	= reviewDaoObj.getReviewsForCommunity(communityID);
		
		String sql = "SELECT T1.* FROM housingboard.user T1 " + 
				"WHERE T1.user_type_id = 2 AND T1.user_id = " + communityID + " AND isActive IS TRUE limit 1";
		
		System.out.println("SQL inside getCommunitySummaryDetails page : " + sql);
		
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement(sql);
			
			System.out.println("Conn : " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				CommunitySummary commuSummObj = new CommunitySummary();
				commuSummObj.setId(rs.getInt("user_id"));
				commuSummObj.setName(rs.getString("user_name"));
				commuSummObj.setImageUrl(rs.getString("community_image_url"));
				commuSummObj.setPageDescription(rs.getString("community_page_description"));
			
				commuSummObj.setReviewsCommunity(reviewList);
				return commuSummObj;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	public boolean getUserCommunityPgAssoc(int userId, int communityID) {
		String sql = "SELECT count(*) as rowCount FROM housingboard.review where "
				+ "review_target_user_id = "+communityID+" AND review_reviewer_user_id = "+userId+"";
		
		System.out.println("SQL inside getCommunitySummaryDetails page : " + sql);
		
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement(sql);
			
			System.out.println("Conn : " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("Inside IF getUserCommunityPgAssoc");
				int rowCount = rs.getInt("rowCount");
				System.out.println("rowCount : " + rowCount);
				if(rowCount == 0) {
					return false;
				}else {
					return true;
				}
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return false;
	}

	public boolean updateCommunityPageData(CommunitySummary communitySummObj) {
		String sql = "";
		try {
			if(communitySummObj.isImgUrlSet()) {
				sql = "UPDATE USER SET user_name = '"+communitySummObj.getName()+"', "
						+ "community_page_description = '"+communitySummObj.getPageDescription()+"', "
								+ "community_image_url = '"+communitySummObj.getImageUrl()+"'"
								+ " where user_id = "+communitySummObj.getId()+"";
			}else {
				sql = "UPDATE USER SET user_name = '"+communitySummObj.getName()+"', "
						+ "community_page_description = '"+communitySummObj.getPageDescription()+"'"
								+ " where user_id = "+communitySummObj.getId()+"";
			}
			conn = db.getConnection();	
			ps = conn.prepareStatement(sql);
			System.out.println("Connection updateCommunityPageData: "+ps);
			ps.executeUpdate();
			conn.close();
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

}
