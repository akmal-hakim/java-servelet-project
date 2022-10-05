package review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import connection.ConnectionManager;
import product.model.ProductBean;
import review.model.reviewBean;

public class reviewDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static int payment_id, review_star, review_id;
	static String review_text;
	
	public void createReview(reviewBean bean) {
		payment_id = bean.getPaymentID();
		review_star = bean.getReviewStar();
		review_text = bean.getReviewText();
		
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("insert into review(payment_id, review_text, review_star)values(?,?,?)");
			ps.setInt(1, payment_id);
			ps.setString(2, review_text);
			ps.setInt(3, review_star);
			ps.executeUpdate();
		}	catch (SQLException e) {
			 e.printStackTrace();
		}
	}
	
	public boolean deleteReview(int review_id) {
		try {
			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement("delete from review where review_id=?");
			ps.setInt(1, review_id);
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static List<reviewBean> getReviewByCustomerID(int customer_id) {
		List<reviewBean> reviewList = new LinkedList<reviewBean>();
		String sql = "select * from review r join payment p1 on r.payment_id = p1.payment_id join product p2 on p1.product_id = p2.product_id join customer c on c.customer_id = p1.customer_id where c.customer_id = '" + customer_id + "' order by p1.payment_date";
		Statement stmt = null;
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				reviewBean rb = new reviewBean();
				
				rb.setReviewID(rs.getInt("review_id"));
				rb.setReviewStar(rs.getInt("review_star"));
				rb.setReviewText(rs.getString("review_text"));
				rb.setPaymentDate(rs.getString("payment_date"));
				rb.setCustomerEmail(rs.getString("customer_email"));
				rb.setProductName(rs.getString("product_name"));
				reviewList.add(rb);
			}
			
		}	catch(SQLException e) {
			e.printStackTrace();
		}
		return reviewList;
	}
	
	public static List<reviewBean> getReviewByProductID(int product_id) {
		List<reviewBean> reviewList = new LinkedList<reviewBean>();
		String sql = "select * from review r join payment p1 on r.payment_id = p1.payment_id join product p2 on p1.product_id = p2.product_id join customer c on c.customer_id = p1.customer_id where p2.product_id = '" + product_id + "'";
		Statement stmt = null;
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				reviewBean rb = new reviewBean();
				
				rb.setReviewID(rs.getInt("review_id"));
				rb.setReviewStar(rs.getInt("review_star"));
				rb.setReviewText(rs.getString("review_text"));
				rb.setPaymentDate(rs.getString("payment_date"));
				rb.setCustomerEmail(rs.getString("customer_email"));
				rb.setProductName(rs.getString("product_name"));
				reviewList.add(rb);
			}
			
		}	catch(SQLException e) {
			e.printStackTrace();
		}
		return reviewList;
	}
	
	public static List<reviewBean> getAllReview() {
        List<reviewBean> reviewList = new LinkedList<reviewBean>();
        String sql = "select * from review r join payment p1 on r.payment_id = p1.payment_id join product p2 on p1.product_id = p2.product_id join customer c on c.customer_id = p1.customer_id order by p1.payment_date ";
        Statement stmt = null;
        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                reviewBean rb = new reviewBean();

                rb.setReviewID(rs.getInt("review_id"));
                rb.setReviewStar(rs.getInt("review_star"));
                rb.setReviewText(rs.getString("review_text"));
                rb.setPaymentDate(rs.getString("payment_date"));
                rb.setCustomerEmail(rs.getString("customer_email"));
                rb.setProductName(rs.getString("product_name"));
                reviewList.add(rb);
            }

        }    catch(SQLException e) {
            e.printStackTrace();
        }
        return reviewList;
    }
	
	public static reviewBean getReviewByReviewId(int review_id) {
		reviewBean rb = new reviewBean();
		
		//String sql = "select * from review r join payment p1 on r.payment_id = p1.payment_id join product p2 on p1.product_id = p2.product_id join customer c on c.customer_id = p1.customer_id where r.review_id = '" + review_id + "'";
		String sql = "select * from review where review_id = '" + review_id + "'";
		Statement stmt = null;
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				
				rb.setReviewID(rs.getInt("review_id"));
				rb.setReviewStar(rs.getInt("review_star"));
				rb.setReviewText(rs.getString("review_text"));
			}
			
		}	catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.print(rb.toString());
		return rb;	
	}
	
	
	
	public static void updateReview(reviewBean bean) {
		review_id = bean.getReviewID();
		review_star = bean.getReviewStar();
		review_text = bean.getReviewText();
		
		
		try {
			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement("update review set review_star=?, review_text=? where review_id=?");
			ps.setInt(1, review_star);
			ps.setString(2, review_text);
			ps.setInt(3, review_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
