package com.housingboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.housingboard.dao.AdsDao;
import com.housingboard.dao.AdsDaoImpl;
import com.housingboard.model.Ads;

/**
 * Servlet implementation class AdsController
 */
@WebServlet("/ads")
public class AdsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdsController() {
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
		System.out.println("Session userAuthToken : " + session.getAttribute("userAuthToken"));
		if(session.getAttribute("userAuthToken").equals("")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}else {
			
			int userId= Integer.parseInt(session.getAttribute("userAuthToken").toString());
			String adTitle = request.getParameter("title");
			String adImageUrl = request.getParameter("imageUrl");
			String adDescription = request.getParameter("description");
			String adCommunity = request.getParameter("community");
			
			Ads adModel = new Ads(adTitle, adImageUrl, userId, true, adDescription, adCommunity);
			
			AdsDao adDao = new AdsDaoImpl();
			boolean adCreated = adDao.createNewAd(adModel);
			
			if(adCreated) {
				session.setAttribute("message", "AD has been posted successfully but the USER!");
			}else {
				session.setAttribute("message", "Something went wrong. Please try again later.");
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/suMessage.jsp");
			dispatcher.forward(request, response);
			
		}
		
	}

}
