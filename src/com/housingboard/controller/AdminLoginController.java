package com.housingboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.housingboard.dao.AdminDao;
import com.housingboard.dao.AdminDaoImpl;
import com.housingboard.dao.LeasingOfficeDaoImpl;
import com.housingboard.dao.MemberDaoImpl;
import com.housingboard.dao.UserDao;
import com.housingboard.model.LeasingOffice;
import com.housingboard.model.Login;
import com.housingboard.model.Member;
/**
 * Servlet implementation class Login
 */
@WebServlet("/adminlogin")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    public AdminLoginController() {
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
		System.out.println("IN Admin Login Controller !");
		String email_id = request.getParameter("email_id");
		String password = request.getParameter("password");
		Login loginModel = new Login(email_id, password);
		String viewUrl;
		HttpSession session = request.getSession(false);
//			Member

			AdminDao memberUser = new AdminDaoImpl();
			Member memberModel = (Member) memberUser.loginUser(loginModel);
			viewUrl = "/adminDashboard.jsp";
			session.setAttribute("userAuthToken",memberModel.getId());		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewUrl);
		dispatcher.forward(request, response);	
		
	}

	
}