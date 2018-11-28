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
import com.housingboard.dao.AdminDaoImpl;
import com.housingboard.dao.AdminDao;
import com.housingboard.model.UserModel;

@WebServlet(urlPatterns = "/admin/*")
public class AdminController extends HttpServlet{
	int userId;
	private static final long serialVersionUID = 1L;
	private AdminDaoImpl adminDao = new AdminDaoImpl();
	
	public AdminController() 
	{
		super();
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		doGet(request, response);
		HttpSession session = request.getSession(false);	
        if(session.getAttribute("userAuthToken") == null) {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
        }
        else {
        	 try {
        		 userId = Integer.parseInt(session.getAttribute("userAuthToken").toString());
	    			String[] values = request.getRequestURI().split("/");
	    	        System.out.print(values); 
	    	        System.out.print(values[3]);
        		switch (values[3]) {
        			case "listalluser":
        				listAllUsers(request, response);
        				break;
		            case "deleteUser":
		            	System.out.println("in delete");
		            	int id = Integer.parseInt(request.getParameter("id"));
		            	System.out.println("My id is"+id);
		                deleteUser(request, response,id);
		                break;
		            default:
		            	System.out.println("not in delete");
		            	listAllUsers(request, response);
        				break;
        			}
		        } catch (SQLException ex) {
					
		            throw new ServletException(ex);
		        }
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    private void deleteUser(HttpServletRequest request, HttpServletResponse response, int id)
            throws SQLException, IOException,ServletException {
    	String viewUrl;
    	HttpSession session = request.getSession(false);	
    	System.out.println("in delete");
        adminDao.deleteUser(id);
        viewUrl = "/adminDashboard.jsp";
        session.setAttribute("message", "Deleted successfully");
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewUrl);
		dispatcher.forward(request, response);	
    }
    private void listAllUsers(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, IOException, ServletException {
    	 List<UserModel> listUsers = adminDao.AdminlistAllUsers();
	        request.setAttribute("listalluser", listUsers);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/allUser.jsp");
	        dispatcher.forward(request, response);	
    }
}
