package customer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.dao.reviewDAO;

/**
 * Servlet implementation class CustomerViewReviewProductController
 */
@WebServlet("/CustomerViewReviewProductController")
public class CustomerViewReviewProductController extends HttpServlet {
	private reviewDAO dao;
	public CustomerViewReviewProductController() {
		super();
		dao = new reviewDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int product_id = Integer.parseInt(request.getParameter("productid"));
		
		request.setAttribute("reviewList", dao.getReviewByProductID(product_id));
		RequestDispatcher view = request.getRequestDispatcher("customerViewProductReview.jsp");
		view.forward(request, response);
	}


}
