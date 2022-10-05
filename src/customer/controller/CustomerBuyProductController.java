package customer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import payment.dao.paymentDAO;
import payment.model.paymentBean;
import product.dao.ProductDAO;
import product.model.ProductBean;
@WebServlet("/CustomerBuyProductController")
public class CustomerBuyProductController extends HttpServlet {
	
	private ProductDAO dao;
	private paymentDAO dao2;
	private static String LIST_ALL = "customerUpdateAccount.jsp";
	String forward = "";
	
	public CustomerBuyProductController() {
		super();
		dao = new ProductDAO();
		dao2 = new paymentDAO();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		int product_id = Integer.parseInt(request.getParameter("productid"));

		ProductBean pb = dao.getProductById(product_id);
		request.setAttribute("pb", pb);
		RequestDispatcher view = request.getRequestDispatcher("customerCart.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		String customer_email=(String)session.getAttribute("currentSessionUser");
		int customer_id=(int)session.getAttribute("currentSessionUserid");
		ProductBean pb = new ProductBean();
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		int product_count = Integer.parseInt(request.getParameter("product_count"));
		double price = Double.parseDouble(request.getParameter("product_price"));
		int quantity = Integer.parseInt(request.getParameter("quantity")); 
		int currentStock = product_count-quantity;
		price = price * quantity;
		
		String pattern = "MM/dd/yyyy HH:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);
		Date today = Calendar.getInstance().getTime();
		String todayAsString = df.format(today);
		System.out.println(quantity);
		System.out.println(product_count);
		System.out.println(currentStock);
		
		paymentBean pab = new paymentBean();
		pab.setCustomerID(customer_id);
		pab.setProductID(product_id);
		pab.setPaymentDate(todayAsString);
		pab.setPaymentPrice(price);
		pab.setQuantity(quantity);
		
		dao.updateBuyProduct(product_id,currentStock);
		dao2.createPayment(pab);
		request.setAttribute("paymentList", paymentDAO.getPaymentForReviewByCustomerID(customer_id));
		RequestDispatcher view = request.getRequestDispatcher("customerViewPayment.jsp");
		view.forward(request, response);
	}
	
	
}
