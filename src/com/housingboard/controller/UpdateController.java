package com.housingboard.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import com.housingboard.dao.DbManager;
import com.housingboard.dao.LeasingOfficeDaoImpl;
import com.housingboard.dao.MemberDaoImpl;
import com.housingboard.dao.UserDao;
import com.housingboard.model.Ads;
import com.housingboard.model.LeasingOffice;
import com.housingboard.model.Member;
import com.housingboard.model.UserModel;


@WebServlet("/updateUser")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection conn;
	static PreparedStatement ps;
//	int userType;
//	String password;
	DbManager db = new DbManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
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
		System.out.println("In Update Controller");		
		String userEmail = request.getParameter("email_id");;
		String userFullName = request.getParameter("full_name");
		String userPhoneNo = request.getParameter("phone_no");
		String userAddress = request.getParameter("address");
		String userZipCode = request.getParameter("zipcode");
		String userCity = request.getParameter("city");
		String userState = request.getParameter("state");
		String userCountry = request.getParameter("country");
		boolean registrationStatus = false;
		String viewUrl;
		HttpSession session = request.getSession(false);	
		int id = Integer.parseInt(session.getAttribute("userAuthToken").toString());
		int userType = Integer.parseInt(session.getAttribute("userType").toString());
		System.out.println(userFullName);
		if(userType == 1) {
			UserModel member = new Member(userFullName, userPhoneNo, userAddress, userEmail, userCity, userState, 
					userCountry, userZipCode,id);
			
			UserDao memberService = new MemberDaoImpl();
			registrationStatus = memberService.updateMember(member);
			System.out.println(registrationStatus+"in update user");
		}
		else {
			System.out.println("Leasing Office User");
			UserModel leasingOffice = new LeasingOffice(userFullName, userPhoneNo, userAddress, userEmail, userCity, 
					userState, userCountry, userZipCode,id);
			
			UserDao leasingOfficeService = new LeasingOfficeDaoImpl();
			registrationStatus = leasingOfficeService.updateMember(leasingOffice);
		}
		
		if(registrationStatus==true && userType==2) {
			viewUrl = "/loDashboard.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewUrl);
			dispatcher.forward(request, response);	
		}	
		if(registrationStatus==true && userType==1) {
			viewUrl = "/memberDashboard.jsp";
			
			//if(userTypeDropDown.equals("member")) {
//				session.setAttribute("message", "The member was updated successfully");
			//}
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewUrl);
			dispatcher.forward(request, response);	
		}
		
		
	}
	
}