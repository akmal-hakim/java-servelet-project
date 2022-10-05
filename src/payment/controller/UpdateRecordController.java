package payment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import payment.dao.paymentDAO;
import payment.model.paymentBean;
import product.dao.ProductDAO;
import review.dao.reviewDAO;
import review.model.reviewBean;

/**
 * Servlet implementation class UpdateRecordController
 */
@WebServlet("/UpdateRecordController")
public class UpdateRecordController extends HttpServlet {
	private paymentDAO dao;  
	private static String LIST_ALL = "viewrecord.jsp";
	String forward = "";
	public UpdateRecordController() {
		super();
		dao = new paymentDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int payment_id = Integer.parseInt(request.getParameter("payment_id"));
		
		paymentBean pb =dao.getRecordById(payment_id);
		System.out.print("aaaa"+pb.toString());
		
		request.setAttribute("pb", pb);
		RequestDispatcher view = request.getRequestDispatcher("adminUpdateRecord.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		paymentBean pb = new paymentBean();
		int payment_id = Integer.parseInt(request.getParameter("payment_id"));
		int customer_id = Integer.parseInt(request.getParameter("customer_id")); 
		int product_id = Integer.parseInt(request.getParameter("product_id")); 
		int quantity = Integer.parseInt(request.getParameter("quantity")); 
		double payment_price = Double.parseDouble(request.getParameter("payment_price"));
		
		pb.setPaymentID(payment_id);
		pb.setPaymentPrice(payment_price);
		pb.setPaymentDate(request.getParameter("payment_date"));
		pb.setCustomerID(customer_id);
		pb.setProductID(product_id);
		pb.setQuantity(quantity);
		System.out.print("sssssssssssssssssssssss"+pb.toString());
		dao.updateRecord(pb);
		
		forward = LIST_ALL;
		request.setAttribute("paymentList", paymentDAO.getAll());
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}
	

}
