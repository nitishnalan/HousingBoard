package com.housingboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.housingboard.model.Review;

/**
 * @author nitish
 */
public class ReviewDaoImpl {

	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	public List<Review> getReviewsForCommunity(int communityID) {

		List<Review> listOfReviews = new ArrayList<Review>();
		String sql = "SELECT T1.*, T2.user_name FROM housingboard.review T1, housingboard.user T2  WHERE "
				+ "T1.review_target_user_id = "+ communityID + " AND T1.review_reviewer_user_id = T2.user_id "
				+ "AND T2.user_type_id = 1 ORDER BY review_timeStamp DESC";
		
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement(sql);
			
			System.out.println("Conn : " + ps);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				while(rs.next()) {
					Review reviewObj = new Review();
					reviewObj.setId(rs.getInt("review_id"));
					reviewObj.setTargetUserId(rs.getInt("review_target_user_id"));
					reviewObj.setReviewerUserId(rs.getInt("review_reviewer_user_id"));
					reviewObj.setDescription(rs.getString("review_description"));
					reviewObj.setUserName(rs.getString("user_name"));
					
					listOfReviews.add(reviewObj);
				}
				return listOfReviews;
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("Result Set received null for Reviews!!");
		return null;
	}

}
