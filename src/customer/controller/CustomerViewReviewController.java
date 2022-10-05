package customer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.dao.ProductDAO;
import review.dao.reviewDAO;
import review.model.reviewBean;


@WebServlet("/CustomerViewReviewController")
public class CustomerViewReviewController extends HttpServlet {
	private reviewDAO dao;
	public CustomerViewReviewController() {
        super();
        dao = new reviewDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customer_id = Integer.parseInt(request.getParameter("customerid"));
		
		request.setAttribute("reviewList", dao.getReviewByCustomerID(customer_id));
		RequestDispatcher view = request.getRequestDispatcher("customerViewOwnReview.jsp");
		view.forward(request, response);
		
	}

}
