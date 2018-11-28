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

import com.housingboard.dao.AdsDaoImpl;
import com.housingboard.dao.LeasingOfficeDaoImpl;
import com.housingboard.dao.MemberDaoImpl;
import com.housingboard.dao.UserDao;
import com.housingboard.model.Ads;
import com.housingboard.model.LeasingOffice;
import com.housingboard.model.Member;
import com.housingboard.model.UserModel;

@WebServlet(urlPatterns = "/updateprofile/*")
public class UpdateProfile extends HttpServlet {
	
	private MemberDaoImpl member = new MemberDaoImpl();
	private LeasingOfficeDaoImpl lo = new LeasingOfficeDaoImpl();
	 public UpdateProfile() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{ 
			System.out.println("In Update Controller");
			HttpSession session = request.getSession(false);	
	        	 try {
	        		 int userId = Integer.parseInt(session.getAttribute("userAuthToken").toString());
		    			String[] values = request.getRequestURI().split("/");
		    	        System.out.print(values); 
		    	        System.out.print(values[3]);
	        		switch (values[3]) {
	        			case "dataretrieve":
	        				UserdataRetrieve(request, response, userId);
	        				break;
	        			case "createpage":
	        				CreatePage(request, response, userId);
	        				break;
	        			default:
			            	System.out.println("you got some error");
	        				break;	
	        							}	}
	        		catch (SQLException ex) {
	        			System.out.println("in catch");
			            throw new ServletException(ex);
	        								}
	        

	        	 	}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			System.out.println("in do get");
		}

			private void UserdataRetrieve(HttpServletRequest request, HttpServletResponse response, int usid)
			throws SQLException, IOException, ServletException {
			List<UserModel> data = member.dataretrieve(usid);
  			request.setAttribute("users", data);
  			RequestDispatcher dispatcher = request.getRequestDispatcher("/userEditForm.jsp");
  			dispatcher.forward(request, response);
}
			private void CreatePage(HttpServletRequest request, HttpServletResponse response, int usid)
					throws SQLException, IOException, ServletException {
				String description= request.getParameter("pagedescription");
				String url= request.getParameter("url");
				boolean x=	lo.createPage(description,url,usid);
				if(x==true)
				{
		  			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		  			dispatcher.forward(request, response);
				}
		}
}
