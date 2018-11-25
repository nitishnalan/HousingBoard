package com.housingboard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.housingboard.dao.InterestDaoImpl;
import com.housingboard.model.CheckAdInterest;

/**
 * Servlet implementation class CheckInterestRequestController
 */
@WebServlet("/checkAdRequest/*")
public class CheckInterestRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckInterestRequestController() {
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
		String pathInfo = request.getPathInfo();
		
		System.out.println("Path Info : " + pathInfo);
		String[] pathParts = pathInfo.split("/");	
		
		String tempStr = pathParts[1].toString();
		int userId = 0;
		int interestId = 0;
		if(pathParts.length >2) {
			userId = Integer.parseInt(pathParts[2].toString());
			interestId = Integer.parseInt(pathParts[3].toString());
			System.out.println("tempStr : " + tempStr + " userId : " +  userId);
		}
		
		
		switch(tempStr)
		{
			case "reviewInterests":
				getMyAdInterestRequests(request,response);
				break;
				
			case "approve":
				approveUserInterestForAd(request,response, userId, interestId);
				break;
				
			case "decline":
				declineUserInterestForAd(request,response, userId, interestId);
				break;
				
			default:
		/*		int adID = Integer.parseInt(pathParts[1].toString());
				showInterestForAd(adID, request,response);
				break;*/
		}
	}

	private void declineUserInterestForAd(HttpServletRequest request, HttpServletResponse response, int userId, int interestId) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("userAuthToken") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}else {
			InterestDaoImpl declineAdInterestCheckObj  = new InterestDaoImpl();
			boolean flag = false;
			flag = declineAdInterestCheckObj.declineUserInterest(userId, interestId);
			
			if(flag) {
				session.setAttribute("message", "The Interest for this has been Declined now!");
			}else
			{
				session.setAttribute("message", "Something went wrong. Please try again later.");
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/suMessage.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	private void approveUserInterestForAd(HttpServletRequest request, HttpServletResponse response, int userId, int interestId) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("userAuthToken") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}else {
			InterestDaoImpl approveAdInterestCheckObj  = new InterestDaoImpl();
			boolean flag = false;
			flag = approveAdInterestCheckObj.approveUserInterest(userId, interestId);
			
			if(flag) {
				session.setAttribute("message", "The Interest for this has been Approved!");
			}else
			{
				session.setAttribute("message", "Something went wrong. Please try again later.");
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/suMessage.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	private void getMyAdInterestRequests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("userAuthToken") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}else {
			int userId= Integer.parseInt(session.getAttribute("userAuthToken").toString());
			InterestDaoImpl myAdInterestCheckObj  = new InterestDaoImpl();
			List<CheckAdInterest> allUsersInterests = new ArrayList<>(); 
			allUsersInterests = myAdInterestCheckObj.getAllShowInterestsForAdBySingleUser(userId);
			
			request.setAttribute("checkAdUserInterests", allUsersInterests);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/checkRequestOnAds.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
