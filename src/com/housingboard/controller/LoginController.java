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
import com.housingboard.model.Login;
import com.housingboard.model.Member;


/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginController() {
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
		System.out.println("IN Login Controller !");
		String email_id = request.getParameter("email_id");
		String password = request.getParameter("password");
		Login loginModel = new Login(email_id, password);
		String viewUrl;
		HttpSession session = request.getSession(false);
		String userType = request.getParameter("user_type");
		System.out.println("USER-Type : " + userType);
		if(userType.equals("member")) {
//			Member
			System.out.println("Member User");
			UserDao memberUser = new MemberDaoImpl();
			Member memberModel = (Member) memberUser.loginUser(loginModel);
			viewUrl = "/memberDashboard.jsp";
			session.setAttribute("user", memberModel);
			
		}else {
//			Leasing Office 
			System.out.println("Leasing Office User");
			UserDao loUser = new LeasingOfficeDaoImpl();
			LeasingOffice loModel = (LeasingOffice) loUser.loginUser(loginModel);
			viewUrl = "/loDashboard.jsp";
			session.setAttribute("user", loModel);
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewUrl);
		dispatcher.forward(request, response);	
		
	}

}