package admin.controller;

import java.io.IOException;
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
import admin.dao.AdminDAO;
import admin.model.Admin;


/**
 * Servlet implementation class AdminCreateAccountController
 */
@WebServlet("/AdminCreateAccountController")
public class AdminCreateAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDAO dao;
	private static String LIST_ALL = "/home.jsp";
	String forward="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCreateAccountController() {
        super();
        dao = new AdminDAO();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			Admin admin = new Admin();
			 //retrieve input and set email,firstname,lastname,password
			admin.setAdmin_name(request.getParameter("admin_name"));
			admin.setAdmin_password(request.getParameter("admin_password"));
			admin.setAdmin_username(request.getParameter("admin_username"));
			admin = AdminDAO.getAdmin(admin);
			 //if user not exist, add/register the user
			if(!admin.isValid()){
				dao.add1(admin);
			 	request.setAttribute("noerr", true);
				request.getRequestDispatcher("validCreateAccount.jsp").forward(request, response);
			 }
			else {
				request.setAttribute("err", true);
				request.getRequestDispatcher("invalidCreateAccount.jsp").forward(request, response);
			}
			}   

}
