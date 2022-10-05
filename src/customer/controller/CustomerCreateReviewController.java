package customer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.dao.reviewDAO;
import review.model.reviewBean;

@WebServlet("/CustomerCreateReviewController")
public class CustomerCreateReviewController extends HttpServlet {
	private reviewDAO dao;
    public CustomerCreateReviewController() {
        super();
        dao = new reviewDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int payment_id = Integer.parseInt(request.getParameter("payment_id"));
		int customer_id = Integer.parseInt(request.getParameter("customer_id"));
		request.setAttribute("pid", payment_id);
		request.setAttribute("cid", customer_id);
		RequestDispatcher view = request.getRequestDispatcher("customerCreateReview.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int payment_id = Integer.parseInt(request.getParameter("payment_id"));
		int review_star = Integer.parseInt(request.getParameter("review_star"));
		int customer_id = Integer.parseInt(request.getParameter("customer_id"));
		reviewBean rb = new reviewBean();
		rb.setPaymentID(payment_id);
		rb.setReviewText(request.getParameter("review_text"));
		rb.setReviewStar(review_star);
		dao.createReview(rb);
		
		request.setAttribute("reviewList", dao.getReviewByCustomerID(customer_id));
		RequestDispatcher view = request.getRequestDispatcher("customerViewOwnReview.jsp");
		view.forward(request, response);
	}

}
