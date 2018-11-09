package com.housingboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.housingboard.dao.LeasingOfficeDaoImpl;
import com.housingboard.dao.MemberDaoImpl;
import com.housingboard.dao.UserDao;
import com.housingboard.model.LeasingOffice;
import com.housingboard.model.Member;
import com.housingboard.model.UserModel;

@WebServlet("/updateUser")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		String userTypeDropDown = request.getParameter("user_type");		
		String userEmail = request.getParameter("email_id");;
		String userFullName = request.getParameter("full_name");
		String userPassword = request.getParameter("password");
		String userPhoneNo = request.getParameter("phone_no");
		String userAddress = request.getParameter("address");
		String userZipCode = request.getParameter("zipcode");
		String userCity = request.getParameter("city");
		String userState = request.getParameter("state");
		String userCountry = request.getParameter("country");
		
		boolean registrationStatus = false;
		String viewUrl;
		HttpSession session = request.getSession(false);
		
		if(userTypeDropDown.equals("member")) {
			System.out.println("Member User");
			int userType = 1;
			UserModel member = new Member(userFullName, userPhoneNo, userAddress, userEmail, userCity, userState, 
					userCountry, userZipCode, userType, true, userPassword);
			
			UserDao memberService = new MemberDaoImpl();
			registrationStatus = memberService.register(member);
			 
		}else {
			System.out.println("Leasing Office User");
			int userType = 2;
			UserModel leasingOffice = new LeasingOffice(userFullName, userPhoneNo, userAddress, userEmail, userCity, 
					userState, userCountry, userZipCode, userType, true, userPassword);
			
			UserDao leasingOfficeService = new LeasingOfficeDaoImpl();
			
			registrationStatus = leasingOfficeService.register(leasingOffice);
		}
		
		if(registrationStatus) {
			viewUrl = "/su1Message.jsp";
			
			if(userTypeDropDown.equals("member")) {
				session.setAttribute("message", "The member was updated successfully");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewUrl);
			dispatcher.forward(request, response);	
		}
		
		
	}
}
