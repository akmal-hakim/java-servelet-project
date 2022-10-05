package review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.dao.reviewDAO;

/**
 * Servlet implementation class deleteReviewController
 */
@WebServlet("/deleteReviewController")
public class deleteReviewController extends HttpServlet {
	private reviewDAO dao;
	
	public deleteReviewController() {
		super();
		dao = new reviewDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")) {
			int review_id = Integer.parseInt(request.getParameter("review_id"));
			boolean valid = dao.deleteReview(review_id);
			if(valid) {
				request.setAttribute("noerr", true);
				request.getRequestDispatcher("validationDeleteReview.jsp").forward(request, response);
			}
			else {
				request.setAttribute("err", true);
				request.getRequestDispatcher("validationDeleteReview.jsp").forward(request, response);
			}
		}
	}
}
