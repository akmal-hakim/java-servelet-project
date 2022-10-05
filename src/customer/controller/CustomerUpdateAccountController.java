package customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customer.dao.CustomerDAO;
import customer.model.Customer;

@WebServlet("/CustomerUpdateAccountController")
public class CustomerUpdateAccountController extends HttpServlet {
	private CustomerDAO dao;
	
	
	public CustomerUpdateAccountController() {
		super();
		dao = new CustomerDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession(false);
		int customer_id =  (int) session.getAttribute("currentSessionUserid");
		
		Customer acc = dao.getAccountById(customer_id);
		request.setAttribute("acc", acc);
		RequestDispatcher view = request.getRequestDispatcher("customerUpdateAccount.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Customer customer = new Customer();
		 //retrieve input and set email,firstname,lastname,password
		int customer_id = Integer.parseInt(request.getParameter("customer_id"));
		customer.setCustomer_id(customer_id);
		customer.setCustomer_email(request.getParameter("customer_email"));
		customer.setCustomer_password(request.getParameter("customer_password"));
		customer.setCustomer_name(request.getParameter("customer_name"));
		customer.setCustomer_phonenum(request.getParameter("customer_phonenum"));
		customer.setCustomer_address(request.getParameter("customer_address"));
		
		customer = CustomerDAO.getCustomerU(customer);
		
		if(!customer.isValid()) {
			dao.updateAccount(customer);
			request.setAttribute("noerr2", true);
			request.getRequestDispatcher("validationUpdateAccount.jsp").forward(request, response);
		}
		else {
			request.setAttribute("err2", true);
			request.getRequestDispatcher("validationUpdateAccount.jsp").forward(request, response);
		}
	}
}


