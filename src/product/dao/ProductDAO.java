package product.dao;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;

import connection.ConnectionManager;
import product.model.ProductBean;


public class ProductDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static String product_name, product_description;
	static int product_count, product_id;
	static double product_price;
	static int admin_id;
	
	public static void createProduct(ProductBean bean) {
		product_name = bean.getProductName();
		product_description = bean.getProductDesc();
		product_count = bean.getProductCount();
		product_price = bean.getProductPrice();
		product_id = bean.getProductID();
		admin_id = bean.getAdmin_id();
		try {
			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement("insert into product(product_name, product_description, product_price, product_count, admin_id)values(?,?,?,?,?)");
			ps.setString(1, product_name);
			ps.setString(2, product_description);
			ps.setDouble(3, product_price);
			ps.setInt(4, product_count);
			ps.setInt(5, admin_id);
			ps.executeUpdate();
		}	catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ProductBean getProductById(int product_id) {
		ProductBean pb = new ProductBean();
		
		try {
			currentCon = ConnectionManager.getConnection();
			String sql = "select * from product where product_id=?";
			ps = currentCon.prepareStatement(sql);
			ps.setInt(1, product_id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				pb.setProductID(rs.getInt("product_id"));
				pb.setProductName(rs.getString("product_name"));
				pb.setProductDesc(rs.getString("product_description"));
				pb.setAdmin_id(rs.getInt("admin_id"));
				pb.setProductCount(rs.getInt("product_count"));
				pb.setProductPrice(rs.getDouble("product_price"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return pb;
	}
	
	public static void updateProduct(ProductBean bean) {
		product_name = bean.getProductName();
		product_description = bean.getProductDesc();
		product_count = bean.getProductCount();
		product_price = bean.getProductPrice();
		product_id = bean.getProductID();
		
		
		try {
			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement("update product set product_name=?, product_description=?, product_price=?, product_count=? where product_id=?");
			ps.setString(1, product_name);
			ps.setString(2, product_description);
			ps.setDouble(3, product_price);
			ps.setInt(4, product_count);
			ps.setInt(5, product_id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean deleteProduct(int product_id) {
		try {
			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement("delete from product where product_id=?");
			ps.setInt(1, product_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static void updateBuyProduct(int product_id, int currentStock) {
		
		try {
			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement("update product set product_count=? where product_id=?");
			ps.setInt(1, currentStock);
			ps.setInt(2, product_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<ProductBean> getAll() {
		List<ProductBean> productList = new ArrayList<ProductBean>();
		String sql = "select * from product join admin on admin.admin_id = product.admin_id";
		Statement stmt = null;
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				ProductBean pb = new ProductBean();
                
				pb.setProductID(rs.getInt("product_id"));
				pb.setProductName(rs.getString("product_name"));
				pb.setProductDesc(rs.getString("product_description"));
				pb.setAdmin_name(rs.getString("admin_name"));
				pb.setProductCount(rs.getInt("product_count"));
				pb.setProductPrice(rs.getDouble("product_price"));
				productList.add(pb);
			}
		}	catch(Exception ex) {
			System.out.println(ex);
		}      
        return productList;
	}
}
