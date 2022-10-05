package product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.dao.ProductDAO;
import product.model.ProductBean;

/**
 * Servlet implementation class addProductController
 */
@WebServlet("/CreateProductController")
public class CreateProductController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ProductBean product = new ProductBean();
			
			int admin_id = Integer.parseInt(request.getParameter("admin_id"));
			double product_price = Double.parseDouble(request.getParameter("product_price"));
			int product_count = Integer.parseInt(request.getParameter("product_count"));
			product.setProductName(request.getParameter("product_name"));
			product.setProductDesc(request.getParameter("product_description"));
			product.setProductPrice(product_price);
			product.setProductCount(product_count);
			product.setAdmin_id(admin_id);
			
			ProductDAO.createProduct(product);
			request.setAttribute("productList", ProductDAO.getAll());
			RequestDispatcher view = request.getRequestDispatcher("viewProduct.jsp");
	        view.forward(request, response);
		}	catch(Throwable ex) {
			System.out.println(ex);
		}
	}

}
