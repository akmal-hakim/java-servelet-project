package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.AdminDAO;

/**
 * Servlet implementation class deleteAccountController
 */
@WebServlet("/deleteAccountController")
public class deleteAccountController extends HttpServlet {
	private static String LIST_ALL = "/viewaccount.jsp";
	private AdminDAO dao;
	
	public deleteAccountController() {
		super();
		dao = new AdminDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")) {
			int admin_id = Integer.parseInt(request.getParameter("admin_id"));
			boolean valid = dao.deleteAdmin(admin_id);
			if(valid) {
				request.setAttribute("noerr", true);
				request.getRequestDispatcher("validationDeleteAccount.jsp").forward(request, response);
			}
			else {
				request.setAttribute("err", true);
				request.getRequestDispatcher("validationDeleteAccount.jsp").forward(request, response);
			}
		}
	}
}
