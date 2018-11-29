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
		if(!session.getAttribute("userAuthToken").toString().equals("") && session.getAttribute("userType")!=null) {
			try {
				int userId = Integer.parseInt(session.getAttribute("userAuthToken").toString());
				int userType = Integer.parseInt(session.getAttribute("userType").toString());
				System.out.println("getPathInfo() : " + request.getPathInfo());
				String[] values = request.getPathInfo().split("/");
				System.out.print(values); 
				System.out.print(values[1]);
				switch (values[1].trim()) {
				case "dataretrieve":
					userDataRetrieve(request, response, userId, userType);
					break;
				case "createpage":
					CreatePage(request, response, userId);
					break;
				default:
					System.out.println("you got some error");
					break;	
				}	
			}
			catch (SQLException ex) {
				System.out.println("in catch");
				throw new ServletException(ex);
			}
		}else {
			session.setAttribute("message", "Please login and try to update your information!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/suMessage.jsp");
			dispatcher.forward(request, response);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("in do get");
	}

	private void userDataRetrieve(HttpServletRequest request, HttpServletResponse response, int userId, int userType)
			throws SQLException, IOException, ServletException {
		if(userType == 1) {
			UserModel data = member.retrieveData(userId);
			request.setAttribute("users", data);
		}else if(userType == 2) {
			UserModel data = lo.retrieveData(userId);
			request.setAttribute("users", data);
		}
		//List<UserModel> data = member.dataretrieve(usid);
		
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
