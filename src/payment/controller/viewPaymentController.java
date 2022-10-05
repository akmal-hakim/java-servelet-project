package payment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import payment.dao.paymentDAO;

/**
 * Servlet implementation class viewPaymentController
 */
@WebServlet("/viewPaymentController")
public class viewPaymentController extends HttpServlet {
    private paymentDAO dao;
	public viewPaymentController() {
        super();
        dao = new paymentDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("paymentList", dao.getAll());
		
		RequestDispatcher view = request.getRequestDispatcher("viewrecord.jsp");
		view.forward(request, response);
	}

}
