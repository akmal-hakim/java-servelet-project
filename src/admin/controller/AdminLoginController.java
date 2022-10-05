package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.dao.AdminDAO;
import admin.model.Admin;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
	try {
	Admin admin = new Admin();
	 //retrieve and set email and password
	admin.setAdmin_username(request.getParameter("admin_username"));
	admin.setAdmin_password(request.getParameter("admin_password"));
	
	admin = AdminDAO.login(admin);
	//set user session if user is valid
	if(admin.isValid()){
	 //get the current session
	HttpSession session = request.getSession(true);
	 //set current session based on email
	session.setAttribute("admin_name", admin.getAdmin_name());
	session.setAttribute("admin_id", admin.getAdmin_id());

	response.sendRedirect("home.jsp"); // logged-in page
	}
	//redirect to invalidLoggin.jsp if user is not valid
	else{
		request.setAttribute("err", true);
		request.getRequestDispatcher("invalidLogin.jsp").forward(request, response);
	}
	}
	catch (Throwable ex) {
	System.out.println(ex);
	}
	}

}
