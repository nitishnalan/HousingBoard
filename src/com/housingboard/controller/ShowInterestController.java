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

import com.housingboard.dao.AdsDao;
import com.housingboard.dao.AdsDaoImpl;
import com.housingboard.dao.InterestDaoImpl;
import com.housingboard.model.Ads;
import com.housingboard.model.UserAdInterest;

/**
 * Servlet implementation class ShowInterestController
 */
@WebServlet("/showAdInterest/*")
public class ShowInterestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowInterestController() {
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
		String[] pathParts = pathInfo.split("/");	
		
		String tempStr = pathParts[1].toString();
		
		switch(tempStr)
		{
			case "myInterests":
				getMyInterests(request,response);
				break;
				
			default:
				int adID = Integer.parseInt(pathParts[1].toString());
				showInterestForAd(adID, request,response);
				break;
		}
		

		
	}

	private void getMyInterests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("userAuthToken") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}else {
			int userId= Integer.parseInt(session.getAttribute("userAuthToken").toString());
			InterestDaoImpl myInterestObj  = new InterestDaoImpl();
			List<UserAdInterest> eachUsersInterests = new ArrayList<>(); 
			eachUsersInterests = myInterestObj.getEachUserInterest(userId);
			
			request.setAttribute("userInterests", eachUsersInterests);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/showMyInterest.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	private void showInterestForAd(int adID, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String viewName = "";
		System.out.println("Show interest adID " + adID);
		HttpSession session = request.getSession(false);
		System.out.println("Session userAuthToken : " + session.getAttribute("userAuthToken"));
		
		if(session.getAttribute("userAuthToken") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}else {
			int userId= Integer.parseInt(session.getAttribute("userAuthToken").toString());
			AdsDao interestForAd = new AdsDaoImpl();
			Ads adDetails = null; 
			adDetails = interestForAd.getDetailsOfAd(adID);
			
			
			if(adDetails == null) {
				System.out.println("AD DETAILS IS NULL");
				session.setAttribute("message", "Something went wrong. Please try to login again.");
				viewName = "/suMessage.jsp";
			}else {
				
				System.out.println("AD DETAILS IS NOT A NULL");
				InterestDaoImpl showInterest = new InterestDaoImpl();
				boolean suFlag = showInterest.insertUserShowsInterestForAd(adDetails,userId);
				
				if(suFlag) {
					session.setAttribute("message", "Your Interest has been recorded. It is awaiting the response from the user who posted the AD.");
					viewName = "/suMessage.jsp";
				}else {
					session.setAttribute("message", "Something went wrong. Please try to login again.");
					viewName = "/suMessage.jsp";
				}
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response);
	}

}
