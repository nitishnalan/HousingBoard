package com.housingboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.housingboard.dao.CommunitySummaryDaoImpl;
import com.housingboard.dao.ReviewDaoImpl;
import com.housingboard.model.CommunitySummary;
import com.housingboard.model.Review;

/**
 * Servlet implementation class ReviewController
 */
@WebServlet("/review/*")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession(false);
		String pathInfo = request.getPathInfo();
		System.out.println("pathInfo in review controller: " + pathInfo);
		String[] pathParts = pathInfo.split("/");
		System.out.println("pathParts[2].toString() : " + pathParts[2]);
		int communityID = Integer.parseInt(pathParts[2].toString());
		
		String actionToPerform = pathParts[1];
		
		System.out.println("actionToPerform : " + actionToPerform);
		
		String viewName = "";
		if(session.getAttribute("userAuthToken") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}else {
			int userId = Integer.parseInt(session.getAttribute("userAuthToken").toString());
			switch(actionToPerform)
			{
				
				case "addReview":
					preprocessDataBeforePostingReview(communityID, request);
					viewName = "/postReview.jsp";
					break;
					
				case "postReview":
					CommunitySummaryDaoImpl communitySummaryDaoImplObj = new CommunitySummaryDaoImpl();
					boolean userCommunityPgAssoc = false;
					userCommunityPgAssoc = communitySummaryDaoImplObj.getUserCommunityPgAssoc(userId,communityID);
					if(!userCommunityPgAssoc) {
						Review reviewObj = new Review();
						reviewObj.setTargetUserId(communityID);
						reviewObj.setReviewerUserId(userId);
						System.out.println("request.getParameter(review) : " + request.getParameter("review"));
						reviewObj.setDescription(request.getParameter("review"));
//						processDataAfterPostingReview(userId,communityID, reviewObj, request);
						processDataAfterPostingReview(reviewObj, request);
						viewName = "/reviewMessage.jsp";
						
						session.setAttribute("reviewMessage", "The review has been posted successfully!");
						session.setAttribute("reviewForCommunityPgId", reviewObj.getTargetUserId());
						
					}else {
						viewName = "/suMessage.jsp";
						session.setAttribute("message", "Something went wrong while posting the review! "
								+ "The user has already "
								+ "posted a review for this community. You can edit your earlier review.");
					}
					
					break;	
					
				default:
//					int adID = Integer.parseInt(pathParts[1].toString());
					viewName = "/suMessage.jsp";
					session.setAttribute("message", "Something went wrong while posting the review!");
					break;
			}			
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response);
	}

	private void processDataAfterPostingReview(Review reviewObj, HttpServletRequest request) {
		ReviewDaoImpl reviewDaoObj = new ReviewDaoImpl();
		boolean isReviewPostedFlag = reviewDaoObj.postReviewForCommunity(reviewObj);
	}

	private void processDataAfterPostingReview(int userId, int communityID, HttpServletRequest request) {
		
		
	}

	private void preprocessDataBeforePostingReview(int communityID, HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		session.setAttribute("reviewForCommunityId", communityID);
		System.out.println("communityID for summary " + communityID);
		CommunitySummary communitySummObj = new CommunitySummary();
		CommunitySummaryDaoImpl communitySummaryDaoImplObj = new CommunitySummaryDaoImpl();
		if(communityID != 0) {
			communitySummObj = communitySummaryDaoImplObj.getCommunitySummaryDetails(communityID);
			
			if(communitySummObj != null) {
				request.setAttribute("communityObjForAddReview", communitySummObj);				
			}
			
		}
	}

}
