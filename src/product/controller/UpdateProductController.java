package product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import payment.dao.paymentDAO;
import product.dao.ProductDAO;
import product.model.ProductBean;

@WebServlet("/UpdateProductController")
public class UpdateProductController extends HttpServlet {
	private ProductDAO dao;
	private static String LIST_ALL = "viewProduct.jsp";
	String forward = "";
	
	public UpdateProductController() {
		super();
		dao = new ProductDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int product_id = Integer.parseInt(request.getParameter("productid"));
		ProductBean pb = dao.getProductById(product_id);
		request.setAttribute("pb", pb);
		
		RequestDispatcher view = request.getRequestDispatcher("updateProduct.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductBean pb = new ProductBean();
		double product_price = Double.parseDouble(request.getParameter("product_price"));
		int product_count = Integer.parseInt(request.getParameter("product_count")); 
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		pb.setProductName(request.getParameter("product_name"));
		pb.setProductDesc(request.getParameter("product_description"));
		pb.setProductPrice(product_price);
		pb.setProductCount(product_count);
		pb.setProductID(product_id);
		dao.updateProduct(pb);
		
		request.setAttribute("productList", ProductDAO.getAll());
		RequestDispatcher view = request.getRequestDispatcher(LIST_ALL);
        view.forward(request, response);
	}

}
