package customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customer.dao.CustomerDAO;
import customer.model.Customer;


/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/CustomerLoginController")
public class CustomerLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		
		

	try {
	
	 //retrieve and set email and password
		Customer customer = new Customer();
		Customer ses = new Customer();
		customer.setCustomer_email(request.getParameter("customer_email"));
		customer.setCustomer_password(request.getParameter("customer_password"));
		customer = CustomerDAO.login(customer);
	
	//set user session if user is valid
	if(customer.isValid()){
		//get the current session
		ses = CustomerDAO.getCustomer(customer);
		HttpSession session = request.getSession(true);
		//set current session based on email
		session.setAttribute("currentSessionUser", ses.getCustomer_email());
		session.setAttribute("currentSessionUserid", ses.getCustomer_id());
	
		String n=(String)session.getAttribute("currentSessionUser"); 
		int n2=(int)session.getAttribute("currentSessionUserid"); 
		System.out.print(n);
		System.out.print(n2);
		response.sendRedirect("customerHome.jsp"); // logged-in page
	}
	//redirect to invalidLoggin.jsp if user is not valid
	else{
		request.setAttribute("err2", true);
		request.getRequestDispatcher("invalidLogin.jsp").forward(request, response);
	}
	}
	catch (Throwable ex) {
	System.out.println(ex);
	}
	}

}