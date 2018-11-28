<<<<<<< HEAD
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
import com.housingboard.model.Filters;

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
		
		//////////////FILTERS/////////////////////
		
		String leasingTypeFilter = request.getParameter("leasingType");
		
		String[] preferencesFilter = request.getParameterValues("preferences");
		
		String ifSharing = request.getParameter("nonsharing");
		
		System.out.println("ifSharing : " + ifSharing);
		
		boolean sharingFilter = Boolean.parseBoolean(ifSharing);
		
		String[] apartmentTypeFilter = request.getParameterValues("apartmentType");
		
		
		
		System.out.println("leasingTypeFilter : " + leasingTypeFilter);
		
		System.out.println("sharing : " + sharingFilter);
		
		if(preferencesFilter != null) {
			for( String s : preferencesFilter) {
				System.out.println("preferencesFilter : " + s);
			}
		}
		
		if(apartmentTypeFilter != null) {
			for( String s : apartmentTypeFilter) {
				System.out.println("apartmentTypeFilter : " + s);
			}
		}
		
		Filters filterObj = new Filters(leasingTypeFilter, apartmentTypeFilter, preferencesFilter, sharingFilter);
		
		/////////////////////////////////////////
		//int pageid = Integer.parseInt(request.getParameter("page"));
		
		
		AdsDao searchResultsOfAds = new AdsDaoImpl();
		List<Ads> listOfAds = new ArrayList<Ads>();
		List<Ads> totalListOfAds = new ArrayList<Ads>();
		
		
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
		
		//ToDo: delete
		//listOfAds = searchResultsOfAds.getSearchResults(searchFieldController);
		
		System.out.println("Inside searchAds Controller : calling DAO");
		
		listOfAds = searchResultsOfAds.getSearchResultsByPageByFilter(searchFieldController, pageid, total, filterObj);
		
//		listOfAds = searchResultsOfAds.getSearchResultsByPage(searchFieldController, pageid, total);
			
		totalListOfAds = searchResultsOfAds.getSearchResults(searchFieldController);
		request.setAttribute("searchResultsOfAds", listOfAds);
		
		HttpSession session = request.getSession(false);
		session.setAttribute("searchField", searchFieldController);
		
		if(listOfAds.size()!=0) {
			session.setAttribute("foundResults", "true");
		}else {
			session.setAttribute("foundResults", "false");
		}
		
		double resultSetSize = (double) totalListOfAds.size();
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

=======
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
import com.housingboard.model.Filters;

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
		System.out.println("INSIDE GET method of SearchAds");
		
//		String pathInfo = request.getPathInfo();
		String pathInfo = request.getRequestURI();
		System.out.println(pathInfo);
		String[] pathParts = pathInfo.split("/");
		
		System.out.println(pathParts[3].toString());
		int pageid = Integer.parseInt(pathParts[3].toString());
		System.out.println("pageid " + pageid);
		
		
		String searchFieldController = request.getParameter("searchfield"); 
		
		//////////////FILTERS/////////////////////
		
		String leasingTypeFilter = request.getParameter("leasingType");
		
		String[] preferencesFilter = request.getParameterValues("preferences");
		
		String ifSharing = request.getParameter("nonsharing");
		
		System.out.println("ifSharing : " + ifSharing);
		
		boolean sharingFilter = Boolean.parseBoolean(ifSharing);
		
		String[] apartmentTypeFilter = request.getParameterValues("apartmentType");
		
		
		
		System.out.println("leasingTypeFilter : " + leasingTypeFilter);
		
		System.out.println("sharing : " + sharingFilter);
		
		if(preferencesFilter != null) {
			for( String s : preferencesFilter) {
				System.out.println("preferencesFilter : " + s);
			}
		}
		
		if(apartmentTypeFilter != null) {
			for( String s : apartmentTypeFilter) {
				System.out.println("apartmentTypeFilter : " + s);
			}
		}
		
		Filters filterObj = new Filters(leasingTypeFilter, apartmentTypeFilter, preferencesFilter, sharingFilter);
		
		/////////////////////////////////////////
		//int pageid = Integer.parseInt(request.getParameter("page"));
		
		
		AdsDao searchResultsOfAds = new AdsDaoImpl();
		List<Ads> listOfAds = new ArrayList<Ads>();
		List<Ads> totalListOfAds = new ArrayList<Ads>();
		
		
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
		
		//ToDo: delete
		//listOfAds = searchResultsOfAds.getSearchResults(searchFieldController);
		
		System.out.println("Inside searchAds Controller : calling DAO");
		
		listOfAds = searchResultsOfAds.getSearchResultsByPageByFilter(searchFieldController, pageid, total, filterObj);
		
//		listOfAds = searchResultsOfAds.getSearchResultsByPage(searchFieldController, pageid, total);
			
		totalListOfAds = searchResultsOfAds.getSearchResults(searchFieldController);
		request.setAttribute("searchResultsOfAds", listOfAds);
		
		HttpSession session = request.getSession(false);
		session.setAttribute("searchField", searchFieldController);
		
		if(listOfAds.size()!=0) {
			session.setAttribute("foundResults", "true");
		}else {
			session.setAttribute("foundResults", "false");
		}
		
		double resultSetSize = (double) totalListOfAds.size();
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
>>>>>>> 1580efb48693261ef9cbfdffba336e4e5a79b950
