package customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.dao.CustomerDAO;
import customer.model.Customer;


/**
 * Servlet implementation class AdminCreateAccountController
 */
@WebServlet("/CustomerCreateAccountController")
public class CustomerCreateAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO dao;
	private static String LIST_ALL = "/home.jsp";
	String forward="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerCreateAccountController() {
        super();
        dao = new CustomerDAO();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			Customer customer = new Customer();
			 //retrieve input and set email,firstname,lastname,password
			customer.setCustomer_email(request.getParameter("customer_email"));
			customer.setCustomer_password(request.getParameter("customer_password"));
			customer.setCustomer_name(request.getParameter("customer_name"));
			customer.setCustomer_phonenum(request.getParameter("customer_phonenum"));
			customer.setCustomer_address(request.getParameter("customer_address"));
			
			customer = CustomerDAO.getCustomer(customer);
			 //if user not exist, add/register the user
			if(!customer.isValid()){
			 try {
			dao.add(customer);
			 } catch (Exception e) {
			e.printStackTrace();
			}
			 	request.setAttribute("noerr2", true);
				request.getRequestDispatcher("validCreateAccount.jsp").forward(request, response);
			 }
			else {
				request.setAttribute("err2", true);
				request.getRequestDispatcher("invalidCreateAccount.jsp").forward(request, response);
			}
	}   

}
