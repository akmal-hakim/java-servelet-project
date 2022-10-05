package payment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


import connection.ConnectionManager;
import payment.model.paymentBean;
import review.model.reviewBean;

public class paymentDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static String payment_date;
	static int payment_id, product_id, customer_id, quantity;
	static double payment_price;
	public static void createPayment(paymentBean bean) {
		try {
			currentCon = ConnectionManager.getConnection();
			payment_date = bean.getPaymentDate();
			product_id = bean.getProductID();
			customer_id = bean.getCustomerID();
			quantity = bean.getQuantity();
			payment_price = bean.getPaymentPrice();
			ps = currentCon.prepareStatement("insert into payment (payment_price,payment_date,customer_id,product_id, quantity) values (?,?,?,?,?)");
			ps.setDouble(1, payment_price);
			ps.setString(2, payment_date);
			ps.setInt(3, customer_id);
			ps.setInt(4, product_id);
			ps.setInt(5, quantity);
			ps.executeUpdate();
		}	catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<paymentBean> getPaymentForReviewByCustomerID(int customer_id) {
		List<paymentBean> paymentList = new LinkedList<paymentBean>();
		String sql = "select * from payment p1 join product p2 on p1.product_id = p2.product_id join customer c on p1.customer_id = c.customer_id where c.customer_id = '" + customer_id + "' and p1.payment_id NOT IN (select payment_id from review)";
		Statement stmt = null;
			try {
				currentCon = ConnectionManager.getConnection();
				stmt = currentCon.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					paymentBean pb = new paymentBean();
					
					pb.setPaymentID(rs.getInt("payment_id"));
					pb.setPaymentPrice(rs.getDouble("payment_price"));
					pb.setPaymentDate(rs.getString("payment_date"));
					pb.setQuantity(rs.getInt("quantity"));
					pb.setCustomerEmail(rs.getString("customer_email"));
					pb.setProductName(rs.getString("product_name"));
					pb.setCustomerID(rs.getInt("customer_id"));
					paymentList.add(pb);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		return paymentList;
	}
	
	public static List<paymentBean> getAll() {
		List<paymentBean> paymentList = new LinkedList<paymentBean>();
		String sql = "select * from payment p1 join product p2 on p1.product_id = p2.product_id join customer c on p1.customer_id = c.customer_id";
		Statement stmt = null;
			try {
				currentCon = ConnectionManager.getConnection();
				stmt = currentCon.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					paymentBean pb = new paymentBean();
					
					pb.setPaymentID(rs.getInt("payment_id"));
					pb.setPaymentPrice(rs.getDouble("payment_price"));
					pb.setPaymentDate(rs.getString("payment_date"));
					pb.setQuantity(rs.getInt("quantity"));
					pb.setCustomerEmail(rs.getString("customer_email"));
					pb.setProductName(rs.getString("product_name"));
					pb.setCustomerID(rs.getInt("customer_id"));
					paymentList.add(pb);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		return paymentList;
	}
	
	public static paymentBean getRecordById(int payment_id) {
		paymentBean pb = new paymentBean();
		
		//String sql = "select * from review r join payment p1 on r.payment_id = p1.payment_id join product p2 on p1.product_id = p2.product_id join customer c on c.customer_id = p1.customer_id where r.review_id = '" + review_id + "'";
		String sql = "select * from payment where payment_id = '" + payment_id + "'";
		Statement stmt = null;
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				pb.setPaymentID(rs.getInt("payment_id"));
				pb.setPaymentPrice(rs.getDouble("payment_price"));
				pb.setPaymentDate(rs.getString("payment_date"));
				pb.setCustomerID(rs.getInt("customer_id"));
				pb.setProductID(rs.getInt("product_id"));
				pb.setQuantity(rs.getInt("quantity"));
			}
			
		}	catch(SQLException e) {
			e.printStackTrace();
		}
		
		return pb;
	}
	
	public static void updateRecord(paymentBean bean) {
		payment_id = bean.getPaymentID();
		payment_price = bean.getPaymentPrice();
		payment_date = bean.getPaymentDate();
		customer_id = bean.getCustomerID();
		product_id = bean.getProductID();
		quantity = bean.getQuantity();
		
		
		try {
			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement("update payment set payment_price=?, payment_date=?, customer_id=?, product_id=?, quantity=? where payment_id=?");
			ps.setDouble(1, payment_price);
			ps.setString(2, payment_date);
			ps.setInt(3, customer_id);
			ps.setInt(4, product_id);
			ps.setInt(5, quantity);
			ps.setInt(6, payment_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
