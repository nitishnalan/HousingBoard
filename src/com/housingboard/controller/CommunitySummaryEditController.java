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
 * Servlet implementation class CommunitySummaryEditController
 */
@WebServlet({ "/editCommunityPage", "/editCommunityPage/*" })
public class CommunitySummaryEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CommunitySummary communitySummObj = new CommunitySummary();
	CommunitySummaryDaoImpl communitySummaryDaoImplObj = new CommunitySummaryDaoImpl();
    String viewName = "";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunitySummaryEditController() {
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
		String[] pathParts = pathInfo.split("/");
		System.out.println("CommunitySummaryEditController pathInfo : " + pathInfo);
		System.out.println("CommunitySummaryEditController pathParts[1] : " + pathParts[1].toString());
		String action = pathParts[1].toString();
		int communityId = Integer.parseInt(pathParts[2].toString());
		
		switch (action) {
			
			case "fetchData":
				//fetch community page data
				fetchDataCommunityPageData(request, response, session, communityId);
				break;
				
				
			case "updateData":
				//update community page data
				updateDataCommunityPageData(request, response, session, communityId);
				break;
				
			default:
				session.setAttribute("message", "Something went wrong! Please login again and try again.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/suMessage.jsp");
		        dispatcher.forward(request, response);
		        break;
		}
	}

	private void updateDataCommunityPageData(HttpServletRequest request, HttpServletResponse response,
			HttpSession session, int communityId) throws ServletException, IOException {
		String name = request.getParameter("name");
		String imgUrl = request.getParameter("imageUrl");
		String description = request.getParameter("description");
		if(imgUrl.isEmpty()) {
			communitySummObj.setImgUrlSet(false);
			communitySummObj.setName(name.trim());
			communitySummObj.setPageDescription(description.trim());
		}else {
			communitySummObj.setName(name.trim());
			communitySummObj.setPageDescription(description.trim());
			communitySummObj.setImageUrl(imgUrl.trim());
			communitySummObj.setImgUrlSet(true);
		}
		communitySummObj.setId(communityId);
		boolean flag = communitySummaryDaoImplObj.updateCommunityPageData(communitySummObj);
		
		if(flag) {
			session.setAttribute("message", "Page details have been updated!");
		}else {
			session.setAttribute("message", "Something went wrong. Please try again!");
		}
		
		viewName = "/suMessage.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response);
	}

	private void fetchDataCommunityPageData(HttpServletRequest request, HttpServletResponse response,
			HttpSession session, int communityId) throws ServletException, IOException {

		communitySummObj = communitySummaryDaoImplObj.getCommunitySummaryDetails(communityId);
		if(communitySummObj == null) {
			session.setAttribute("message", "Something went wrong. Please try to login again.");
			viewName = "/suMessage.jsp";
			//			RequestDispatcher dispatcher = request.getRequestDispatcher("/suMessage.jsp");
			//			dispatcher.forward(request, response);
		}else {
			request.setAttribute("communityObj", communitySummObj);
			if(session.getAttribute("userAuthToken").toString().equals("")) {
				
				session.setAttribute("message", "Something went wrong. Please try to login again.");
				viewName = "/suMessage.jsp";	
			}else {
				viewName = "/editCommunitySummaryPage.jsp";
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response);
	}

}
