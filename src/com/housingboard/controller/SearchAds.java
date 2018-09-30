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

import com.housingboard.dao.AdsDao;
import com.housingboard.dao.AdsDaoImpl;
import com.housingboard.model.Ads;

/**
 * Servlet implementation class SearchAds
 */
@WebServlet("/searchAds")
public class SearchAds extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAds() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String searchFieldController = request.getParameter("searchfield"); 
		AdsDao searchResultsOfAds = new AdsDaoImpl();
		List<Ads> listOfAds = new ArrayList<Ads>();
		
		listOfAds = searchResultsOfAds.getSearchResults(searchFieldController);
		
		
		request.setAttribute("searchResultsOfAds", listOfAds);
		
		String viewUrl = "/searchAds.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewUrl);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
