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
import com.housingboard.model.Ads;

/**
 * Servlet implementation class SearchAds
 */
@WebServlet("/searchAds/*")

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
		System.out.println("INSIDE GET mthod of SearchAds");
		
		String pathInfo = request.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		int pageid = Integer.parseInt(pathParts[1].toString());
		System.out.println("pageid " + pageid);
		
		
		String searchFieldController = request.getParameter("searchfield"); 
		
		//int pageid = Integer.parseInt(request.getParameter("page"));
		AdsDao searchResultsOfAds = new AdsDaoImpl();
		List<Ads> listOfAds = new ArrayList<Ads>();
		
		
		
		//pagination logic
		//set total size you would like to display
		double totalD=2;
		double pageID2;
		int total= (int) totalD;
		if(pageid==1){}  
		else{  
			pageID2=(pageid-1)*totalD+1;  
			pageid = (int) pageID2;
		} 
		
		//listOfAds = searchResultsOfAds.getSearchResults(searchFieldController);
	
		listOfAds = searchResultsOfAds.getSearchResultsByPage(searchFieldController, pageid, total);
			
		
		request.setAttribute("searchResultsOfAds", listOfAds);
		
		HttpSession session = request.getSession(false);
		session.setAttribute("searchField", searchFieldController);
		
		if(listOfAds.size()!=0) {
			session.setAttribute("foundResults", "true");
		}else {
			session.setAttribute("foundResults", "false");
		}
		
		double resultSetSize = (double) listOfAds.size();
		double totalPagesRequired = Math.round(resultSetSize/totalD);
		int totalPages = (int) totalPagesRequired;
		session.setAttribute("totalPages", totalPages);
		
		
		
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
