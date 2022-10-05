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
 * Servlet implementation class viewReviewController
 */
@WebServlet("/viewReviewController")
public class viewReviewController extends HttpServlet {
    private reviewDAO dao;
    public viewReviewController() {
        super();
        dao = new reviewDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("reviewList", dao.getAllReview());
        RequestDispatcher view = request.getRequestDispatcher("adminViewReview.jsp");
        view.forward(request, response);

    }

}