package com.housingboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RedirectController
 */
@WebServlet("/redirect/*")
public class RedirectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectController() {
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
		System.out.println("RedirectController pathInfo : " + pathInfo);
		String tempStr = pathParts[1].toString();
		HttpSession session = request.getSession(false);
		
		switch(tempStr)
		{
			case "dashBoard":
				int userType = Integer.parseInt(session.getAttribute("userType").toString());
				String viewName = "";
				if(userType == 1) {
					viewName = "/memberDashboard.jsp";
				}else if(userType == 2) {
					viewName = "/loDashboard.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
				dispatcher.forward(request, response);
				break;
				
			default:
				session.setAttribute("messsage", "Something went wrong!");
				RequestDispatcher dispatcher2 = request.getRequestDispatcher("/suMessage.jsp");
				dispatcher2.forward(request, response);
				break;
		}
	}

}
