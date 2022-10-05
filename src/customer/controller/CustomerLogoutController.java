package customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerLogoutController
 */
@WebServlet("/CustomerLogoutController")
public class CustomerLogoutController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(true);
			
			session.setAttribute("currentSessionUser", null);
			session.setAttribute("currentSessionUserid", null);
			session.invalidate();
			
			response.sendRedirect("index.jsp");
		}	catch (Throwable ex) {
			System.out.println(ex);
		}
	}
}
