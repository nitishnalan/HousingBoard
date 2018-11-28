package com.housingboard.controller;

import java.io.IOException;
import java.sql.SQLException;
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

//Class for Ads Controller
@WebServlet(urlPatterns = "/ads/*")
public class AdsController extends HttpServlet {
	
	int userId, idToUpdate = 0;
	private static final long serialVersionUID = 1L;
	
	private AdsDaoImpl adsDao = new AdsDaoImpl();

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	}
	 
	 @Override	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException, NumberFormatException {			
			doGet(request, response);
			int id = 0;
			HttpSession session = request.getSession(false);
	        if(session.getAttribute("userAuthToken") == null) {
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
	        }else {
	        	 try {
	        		userId = Integer.parseInt(session.getAttribute("userAuthToken").toString());
	    			System.out.println(userId);
	        		String[] values = request.getRequestURI().split("/");
	        		switch (values[3]) {
			            case "listAds":
			            	listAds(request, response, userId);
			                break;
			            case "insert":
			                insertAds(request, response, userId);
			                break;
			            case "delete":	
			            	id = Integer.parseInt(request.getParameter("id"));
			                deleteAds(request, response, id);
			                break;
		    			case "edit":
		    				showEditForm(request, response);
			                break;
			            case "update":
			            	updateAds(request, response);
			            default:
			            	listAds(request, response, userId);
			                break;
			            }
			        } catch (SQLException ex) {
			            throw new ServletException(ex);
			        }
	        }

	    }
	 

	 private void listAds(HttpServletRequest request, HttpServletResponse response,int userId)
	            throws SQLException, IOException, ServletException {
	        HttpSession session = request.getSession(false);
	    	List<Ads> listAds = adsDao.listAllAds(userId);
	        session.setAttribute("listAds", listAds);
	        //check if the list is null 
	        if(listAds != null)
	        {	        	
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("/AdList.jsp");
		        dispatcher.forward(request, response);
	        }else {
	        	session.setAttribute("message", "The List is Null Dude");
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("/suMessage.jsp");
		        dispatcher.forward(request, response);
	        }
	    }
	 
	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, ServletException, IOException {
	    	int id = Integer.parseInt(request.getParameter("id"));
	    	idToUpdate = id;
	    	System.out.println(idToUpdate);
	        Ads ads = adsDao.getAd(id);
	        request.setAttribute("ads", ads);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/AdUpdateForm.jsp");
	        dispatcher.forward(request, response);
	 
	    }

	    
	    private void insertAds(HttpServletRequest request, HttpServletResponse response, int userId)
	            throws SQLException, IOException {
	    	HttpSession session = request.getSession(false);	
	        String title = request.getParameter("title");
	        String imageUrl = request.getParameter("imageUrl");	        
	        String description = request.getParameter("description");
	        String community = request.getParameter("community");
	        String preferences = "";
	        String[] values = request.getParameterValues("preferences");
	        System.out.println(values[0]);
	        int i = 0;
	        for(String p: values)
	        {
	        	preferences += p;
	        	if(i != values.length - 1)
	        	{
	        		preferences += ",";
		        	i++;
		        	System.out.println(i);
	        	}
	        }
	        String leasingType = "";
	        if(request.getParameter("leasingType") != null)
	        {
	        	System.out.println(request.getParameter("leasingType"));
	        	if(request.getParameter("leasingType").equals("Sub Lease"))
	        	{
	        		leasingType = "Sub Lease";
	        	}else if(request.getParameter("leasingType").equals("New Lease")) {
	        		leasingType = "New Lease";
	        	}
	        }
	       /* boolean sharing = (request.getParameter("sharing").equals("YES") ? true : false);*/
	        boolean sharing;
	        if(request.getParameter("sharing").equals("YES"))
	        {
	        	sharing = true;
	        }else {
	        	sharing = false;
	        }
	        int apartmentTypeId =  Integer.parseInt(request.getParameter("apartmentTypeId"));
	        
	        System.out.println(leasingType);
	        Ads ads = new Ads(title, imageUrl, userId, true, description,
	    		community, preferences, leasingType, sharing, apartmentTypeId);
	   
	        if(adsDao.insertAds(ads)) {
	        	session.setAttribute("message", "Successfully Inserted");
	        }
	        String redirectURL = "http://localhost:8080/HousingBoard/suMessage.jsp";
	        response.sendRedirect(redirectURL);
	        
	    }
	 

	    private void updateAds(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	    	System.out.println("Updating AD");
	    	System.out.println(idToUpdate);
	    	String title = request.getParameter("title");
	        String imageUrl = request.getParameter("imageUrl");
	        String description = request.getParameter("description");
	        String community = request.getParameter("community");
	        String preferences = "";
	        String[] values = request.getParameterValues("preferences");
	        System.out.println(values[0]);
	        int i = 0;
	        for(String p: values)
	        {
	        	preferences += p;
	        	if(values.length == 1)
	        	{
	        	   continue;
	        	}
	        	else if(i != values.length - 2)
	        	{
	        		preferences += ",";
		        	i++;
		        	System.out.println(i);
	        	}
	        }
	        String leasingType = "";
	        if(request.getParameter("leasingType") != null)
	        {
	        	System.out.println(request.getParameter("leasingType"));
	        	if(request.getParameter("leasingType").equals("Sub Lease"))
	        	{
	        		leasingType = "Sub Lease";
	        	}else if(request.getParameter("leasingType").equals("New Lease")) {
	        		leasingType = "New Lease";
	        	}
	        }
	       /* boolean sharing = (request.getParameter("sharing").equals("YES") ? true : false);*/
	        boolean sharing;
	        if(request.getParameter("sharing").equals("YES"))
	        {
	        	sharing = true;
	        }else {
	        	sharing = false;
	        }
	        int apartmentTypeId =  Integer.parseInt(request.getParameter("apartmentTypeId"));
	        
	        Ads ads = new Ads(title, imageUrl, description,
	    			          community, preferences, leasingType, sharing, apartmentTypeId);
	        boolean answer = adsDao.updateAdsFromDatabase(ads, idToUpdate);
	        System.out.print(sharing);
	        System.out.println("Updated ADS in Model");
	        if(answer) {
	        }
	    }
	    	    
	    private void deleteAds(HttpServletRequest request, HttpServletResponse response, int id)
	            throws SQLException, IOException, ServletException {
	    	String viewUrl = "/suMessage1.jsp";
	        Ads ads = new Ads(id);
	        boolean value = adsDao.deleteAdsFromDatabase(ads, id);
	        HttpSession session = request.getSession(false);
	        if(value) {        	 	        	
	        	session.setAttribute("message1", "Deleted Successfully");
	        }else {
	        	session.setAttribute("message1", "Something went wrong while deleting the Ad!");
	        }	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher(viewUrl);
			dispatcher.forward(request, response);
	    }
}


