package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogoutController
 */
@WebServlet("/AdminLogoutController")
public class AdminLogoutController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(true);
		
			session.setAttribute("admin_name", null);
			session.setAttribute("admin_id", null);
			session.invalidate();
			
			response.sendRedirect("index.jsp");
		}	catch (Throwable ex) {
			System.out.println(ex);
		}
	}
}
