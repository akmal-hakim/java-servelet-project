package customer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import payment.dao.paymentDAO;
import payment.model.paymentBean;

@WebServlet("/CustomerViewPaymentController")
public class CustomerViewPaymentController extends HttpServlet {
	private paymentDAO dao;
	public CustomerViewPaymentController() {
		super();
		dao = new paymentDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customer_id = Integer.parseInt(request.getParameter("customerid"));
		
		request.setAttribute("paymentList", dao.getPaymentForReviewByCustomerID(customer_id));
		RequestDispatcher view = request.getRequestDispatcher("customerViewPayment.jsp");
		view.forward(request, response);
	}
}
