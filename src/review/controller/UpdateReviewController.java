package review.controller;

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
import product.dao.ProductDAO;
import product.model.ProductBean;
import review.dao.reviewDAO;
import review.model.reviewBean;

/**
 * Servlet implementation class UpdateReviewController
 */
@WebServlet("/UpdateReviewController")
public class UpdateReviewController extends HttpServlet {
	private reviewDAO dao;  
	private static String LIST_ALL = "home.jsp";
	String forward = "";
	public UpdateReviewController() {
		super();
		dao = new reviewDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int review_id = Integer.parseInt(request.getParameter("review_id"));
		System.out.print("sssssss"+review_id);
		reviewBean rb =dao.getReviewByReviewId(review_id);
		System.out.print(rb.toString());
		
		request.setAttribute("rb", rb);
		RequestDispatcher view = request.getRequestDispatcher("adminUpdateReview.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reviewBean rb = new reviewBean();
		int review_id = Integer.parseInt(request.getParameter("review_id")); 
		int review_star = Integer.parseInt(request.getParameter("review_star"));
		
		System.out.print(review_id + review_star );
		
		rb.setReviewID(review_id);
		rb.setReviewStar(review_star);
		rb.setReviewText(request.getParameter("review_text"));

		dao.updateReview(rb);
		
		request.setAttribute("reviewList", reviewDAO.getAllReview());
		RequestDispatcher view = request.getRequestDispatcher("adminViewReview.jsp");
        view.forward(request, response);
	}
	
}
		


