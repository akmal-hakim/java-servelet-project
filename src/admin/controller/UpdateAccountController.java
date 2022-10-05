package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.AdminDAO;
import admin.model.Admin;

/**
 * Servlet implementation class UpdateAccountController
 */
@WebServlet("/UpdateAccountController")
public class UpdateAccountController extends HttpServlet {
	private AdminDAO dao;
	private static String LIST_ALL = "viewaccount.jsp";
	String forward = "";
	
	public UpdateAccountController() {
		super();
		dao = new AdminDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int admin_id = Integer.parseInt(request.getParameter("admin_id"));
		Admin pb = dao.getAccountById(admin_id);
		request.setAttribute("pb", pb);
		
		RequestDispatcher view = request.getRequestDispatcher("updateAccount.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin pb = new Admin();
		int admin_id = Integer.parseInt(request.getParameter("admin_id"));
		pb.setAdmin_name(request.getParameter("admin_name"));
		pb.setAdmin_username(request.getParameter("admin_username"));
		pb.setAdmin_password(request.getParameter("admin_password"));
		pb.setAdmin_id(admin_id);
		pb = dao.getAdminU(pb);
		
		if(!pb.isValid()) {
			dao.updateAccount(pb);
			request.setAttribute("noerr", true);
			request.getRequestDispatcher("validationUpdateAccount.jsp").forward(request, response);
		}
		else {
			request.setAttribute("err", true);
			request.getRequestDispatcher("validationUpdateAccount.jsp").forward(request, response);
		}
	}

}
