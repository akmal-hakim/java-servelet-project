package customer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.dao.ProductDAO;


@WebServlet("/CustomerViewProductController")
public class CustomerViewProductController extends HttpServlet {
	private static String LIST_ALL = "customerViewProduct.jsp";
	private ProductDAO dao;
	String forward = "";
	
	public CustomerViewProductController() {
		super();
		dao = new ProductDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forward = LIST_ALL;
		request.setAttribute("productList", ProductDAO.getAll());
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
