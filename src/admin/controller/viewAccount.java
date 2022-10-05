package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.AdminDAO;

/**
 * Servlet implementation class viewAccount
 */
@WebServlet("/viewAccount")
public class viewAccount extends HttpServlet {
	private static String LIST_ALL = "viewaccount.jsp";
	private AdminDAO dao;
	String forward = "";
	
	public viewAccount() {
		super();
		dao = new AdminDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forward = LIST_ALL;
		request.setAttribute("AdminList", AdminDAO.getAll());
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
