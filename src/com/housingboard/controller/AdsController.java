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


@WebServlet(urlPatterns = "/ads/*")
public class AdsController extends HttpServlet {
	
	int userId;
	private static final long serialVersionUID = 1L;
	
	private AdsDaoImpl adsDao = new AdsDaoImpl();

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
	 
	 @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	}
	 
	 private void listAds(HttpServletRequest request, HttpServletResponse response,int userId)
	            throws SQLException, IOException, ServletException {
	        HttpSession session = request.getSession(false);
	    	List<Ads> listAds = adsDao.listAllAds(userId);
	        session.setAttribute("listAds", listAds);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/AdList.jsp");
	        dispatcher.forward(request, response);
	    }
	 
	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, ServletException, IOException {
	    	int id = Integer.parseInt(request.getParameter("id"));
	        Ads ads = adsDao.getAd(id);
	        request.setAttribute("ads", ads);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/AdUpdateForm.jsp");
	        dispatcher.forward(request, response);
	 
	    }
	 
	    private void insertAds(HttpServletRequest request, HttpServletResponse response, int userId)
	            throws SQLException, IOException {
	    	System.out.println("Inside ads");
	        String title = request.getParameter("title");
	        String imageUrl = request.getParameter("imageUrl");	        
	        String description = request.getParameter("description");
	        String community = request.getParameter("community");
	        String preferences = request.getParameter("preferences");
	        String leasingtype = request.getParameter("leasingtype");
	        boolean sharing = (request.getParameter("sharing").toString().equals("YES") ? true : false);
	        int apartmentTypeId =  Integer.parseInt(request.getParameter("apartmentTypeId"));
	        
	        Ads ads = new Ads(title, imageUrl, userId,  true, description,
	    		community, preferences, leasingtype, sharing, apartmentTypeId);
	   
	        if(adsDao.insertAds(ads)) {
		        String redirectURL = "http://localhost:8080/HousingBoard/suMessage.jsp";
		        response.sendRedirect(redirectURL);
	        }
	        
	    }
	 
	    private void updateAds(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	    	HttpSession session = request.getSession(false);
	    	int id = Integer.parseInt(request.getParameter("id"));
	    	String title = request.getParameter("title");
	        String imageUrl = request.getParameter("imageUrl");
	        int userId = Integer.parseInt(request.getParameter("userId"));
	        String description = request.getParameter("description");
	        String community = request.getParameter("community");
	        String preferences = request.getParameter("preferences");
	        String leasingtype = request.getParameter("leasingtype");
	        boolean sharing = (request.getParameter("sharing").toString().equals("YES") ? true : false);
	        String is = request.getParameter(String.valueOf("isAvailable"));
	        boolean isAvailable = Boolean.valueOf(is);
	        int apartmentTypeId =  Integer.parseInt(request.getParameter("apartmentTypeId"));
	        Ads ads = new Ads(title, imageUrl, userId,isAvailable , description,
	    			          community, preferences, leasingtype, sharing, apartmentTypeId);
	        if(adsDao.updateAdsFromDatabase(ads, id)) {
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("/AdList.jsp");
		        dispatcher.forward(request, response);
	        }
	    }	 
	    
	    private void deleteAds(HttpServletRequest request, HttpServletResponse response, int id)
	            throws SQLException, IOException, ServletException {
	    	System.out.println("in delete");
	    	String viewUrl = "/suMessage1.jsp";
	        Ads ads = new Ads(id);
	        boolean value = adsDao.deleteAdsFromDatabase(ads, id);
	        HttpSession session = request.getSession(false);
	        if(value) {        	 	        	
	        	session.setAttribute("message", "Deleted Successfully");
	        }else {
	        	session.setAttribute("message", "Something went wrong while deleting the Ad!");
	        }	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher(viewUrl);
			dispatcher.forward(request, response);
	    }
}


