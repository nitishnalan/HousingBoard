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
import com.housingboard.model.CommunitySummary;

/**
 * Servlet implementation class communitySummaryController
 */
@WebServlet("/communitySummary/*")
public class CommunitySummaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunitySummaryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//We get request from ADs Summary page
		HttpSession session = request.getSession(false);
		String pathInfo = request.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		System.out.println(pathParts[1].toString());
		int communityID = Integer.parseInt(pathParts[1].toString());
		boolean userCommunityPgAssoc = false;
		System.out.println("communityID for summary " + communityID);
		
		CommunitySummary communitySummObj = new CommunitySummary();
		CommunitySummaryDaoImpl communitySummaryDaoImplObj = new CommunitySummaryDaoImpl();

		if(communityID != 0) {
			communitySummObj = communitySummaryDaoImplObj.getCommunitySummaryDetails(communityID);
			
			String viewName = "";
			if(communitySummObj == null) {
				session.setAttribute("message", "Something went wrong. Please try to login again.");
				viewName = "/suMessage.jsp";
				//			RequestDispatcher dispatcher = request.getRequestDispatcher("/suMessage.jsp");
				//			dispatcher.forward(request, response);
			}else {
				request.setAttribute("communityObj", communitySummObj);
				if(session.getAttribute("userAuthToken").toString().equals("")) {
					request.setAttribute("userCommunityPgAssoc", userCommunityPgAssoc);
					
					session.setAttribute("message", "Something went wrong. Please try to login again.");
					viewName = "/suMessage.jsp";	
				}else {
					int userId = Integer.parseInt(session.getAttribute("userAuthToken").toString());
					userCommunityPgAssoc = communitySummaryDaoImplObj.getUserCommunityPgAssoc(userId,communityID);
					
					request.setAttribute("userCommunityPgAssoc", userCommunityPgAssoc);
				}
//				request.setAttribute("userAdAssociation", userAdAssociation);
//				System.out.println("postedUserType for an Ad : " + adDetails.getPostedUserType());
//				System.out.println("userAdAssociation : " + userAdAssociation);
				
				
				System.out.println("communityObj Reviews: " + communitySummObj.getReviewsCommunity());
				System.out.println("communityObj Reviews Size: " + communitySummObj.getReviewsCommunity().size());
				viewName = "/communitySummary.jsp";		

			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
			dispatcher.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		HttpSession session = request.getSession(false);
		String pathInfo = request.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		int communityID = Integer.parseInt(pathParts[1].toString());
		boolean userCommunityPgAssoc = false;
		System.out.println("communityID for summary " + communityID);
		
		CommunitySummary communitySummObj = new CommunitySummary();
		CommunitySummaryDaoImpl communitySummaryDaoImplObj = new CommunitySummaryDaoImpl();

		if(communityID != 0) {
			communitySummObj = communitySummaryDaoImplObj.getCommunitySummaryDetails(communityID);
			
			String viewName = "";
			if(communitySummObj == null) {
				session.setAttribute("message", "Something went wrong. Please try to login again.");
				viewName = "/suMessage.jsp";
				//			RequestDispatcher dispatcher = request.getRequestDispatcher("/suMessage.jsp");
				//			dispatcher.forward(request, response);
			}else {
				request.setAttribute("communityObj", communitySummObj);
				if(session.getAttribute("userAuthToken") == null) {
					request.setAttribute("userCommunityPgAssoc", userCommunityPgAssoc);
					
					session.setAttribute("message", "Something went wrong. Please try to login again.");
					viewName = "/suMessage.jsp";	
				}else {
					int userId = Integer.parseInt(session.getAttribute("userAuthToken").toString());
					userCommunityPgAssoc = communitySummaryDaoImplObj.getUserCommunityPgAssoc(userId,communityID);
					
					request.setAttribute("userCommunityPgAssoc", userCommunityPgAssoc);
				}
//				request.setAttribute("userAdAssociation", userAdAssociation);
//				System.out.println("postedUserType for an Ad : " + adDetails.getPostedUserType());
//				System.out.println("userAdAssociation : " + userAdAssociation);
				
				
				System.out.println("communityObj Reviews: " + communitySummObj.getReviewsCommunity().toString());
				System.out.println("communityObj Reviews Size: " + communitySummObj.getReviewsCommunity().size());
				viewName = "/communitySummary.jsp";		

			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
			dispatcher.forward(request, response);
		}
	}

}
