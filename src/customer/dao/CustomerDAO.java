package customer.dao;

import java.sql.*;
import java.util.*;

import connection.ConnectionManager;
import customer.model.Customer;

public class CustomerDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static int customer_id;
	static String customer_email, customer_password, customer_name, customer_phonenum, customer_address;
	
	//method for login
	public static Customer login(Customer bean){
	 //get email and password
		customer_email = bean.getCustomer_email();
		customer_password = bean.getCustomer_password();
	 System.out.println(customer_email);
	 System.out.println(customer_password);

	 String query = "select * from customer where customer_email='" + customer_email + "' AND customer_password='" + customer_password + "'";
	 try {
		 currentCon = ConnectionManager.getConnection();
		 stmt = currentCon.createStatement();
		 rs = stmt.executeQuery(query);
		 boolean more = rs.next();
		 // if user exists set the isValid variable to true
		 if (more) {
			 String customer_email = rs.getString("customer_email");
			 bean.setCustomer_email(customer_email);
			 bean.setValid(true);
		 }
		 // if user does not exist set the isValid variable to false
		 else if (!more) {
			 bean.setValid(false);
		 }
	 } catch (SQLException e) {
	 e.printStackTrace();
	 }

	 return bean;
	}
	public void add(Customer bean){
		 //get email,firstname,lastname and password
		 customer_email = bean.getCustomer_email();
		 customer_password = bean.getCustomer_password();
		 customer_name = bean.getCustomer_name();
		 customer_phonenum = bean.getCustomer_phonenum();
		 customer_address = bean.getCustomer_address();
		 System.out.println(customer_email);
		 System.out.println(customer_password);
		 try {
		 //create connection
		 currentCon = ConnectionManager.getConnection();
		 //create statement
		 ps=currentCon.prepareStatement("insert into customer(customer_email,customer_password,customer_name,customer_phonenum,customer_address)values(?,?,?,?,?)");
		 ps.setString(1,customer_email);
		 ps.setString(2,customer_password);
		 ps.setString(3,customer_name);
		 ps.setString(4,customer_phonenum);
		 ps.setString(5,customer_address);
		 //execute statement
		 ps.executeUpdate();
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		}
	public void updateAccount(Customer bean) {
		
		customer_name = bean.getCustomer_name();
		customer_email = bean.getCustomer_email();
		customer_password = bean.getCustomer_password();
		customer_phonenum = bean.getCustomer_phonenum();
		customer_address = bean.getCustomer_address();
		customer_id = bean.getCustomer_id();

		try {
			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement("update customer set customer_name=?, customer_email=?, customer_password=?, customer_phonenum=?, customer_address=?  where customer_id=?");
			ps.setString(1, customer_name);
			ps.setString(2, customer_email);
			ps.setString(3, customer_password);
			ps.setString(4, customer_phonenum);
			ps.setString(5, customer_address);
			ps.setInt(6, customer_id);
			ps.executeUpdate();
			
			System.out.print("jadike");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public static Customer getCustomer(Customer bean) {
		 //get email
		customer_email = bean.getCustomer_email();
		 String searchQuery = "select * from customer where customer_email='" + customer_email + "'";
		 try {
		 //create connection
		 currentCon = ConnectionManager.getConnection();
		 //create statement
		 stmt = currentCon.createStatement();
		 //execute statement
		 rs = stmt.executeQuery(searchQuery);
		 boolean more = rs.next();
		 // if user exists set the isValid variable to true
		 if (more) {
			 String customer_email = rs.getString("customer_email");
			 int customer_id = rs.getInt("customer_id");
			 bean.setCustomer_id(customer_id);
			 bean.setCustomer_email(customer_email);
			 bean.setValid(true);
		 }
		 // if user does not exist set the isValid variable to false
		 else if (!more) {
		 bean.setValid(false);
		 }
		 }
		 catch (SQLException e) {
		 e.printStackTrace();
		 }
		 return bean;
		}
	
	public static Customer getCustomerU(Customer bean) {
		 //get email
		customer_email = bean.getCustomer_email();
		customer_id = bean.getCustomer_id();
		 String searchQuery = "select * from customer where customer_email='" + customer_email + "' and customer_id !='" + customer_id + "'";
		 try {
		 //create connection
		 currentCon = ConnectionManager.getConnection();
		 //create statement
		 stmt = currentCon.createStatement();
		 //execute statement
		 rs = stmt.executeQuery(searchQuery);
		 boolean more = rs.next();
		 // if user exists set the isValid variable to true
		 if (more) {
			 bean.setValid(true);
		 }
		 // if user does not exist set the isValid variable to false
		 else if (!more) {
		 bean.setValid(false);
		 }
		 }
		 catch (SQLException e) {
		 e.printStackTrace();
		 }
		 return bean;
		}
	
	public static Customer getAccountById(int cid) {
		
		Customer acc = new Customer();
		String sql = "select * from customer where customer_id='" + cid + "'";
		Statement stmt = null;
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				acc.setCustomer_id(rs.getInt("customer_id"));
				acc.setCustomer_name(rs.getString("customer_name"));
				acc.setCustomer_email(rs.getString("customer_email"));
				acc.setCustomer_password(rs.getString("customer_password"));
				acc.setCustomer_phonenum(rs.getString("customer_phonenum"));
				acc.setCustomer_address(rs.getString("customer_address"));
			}
		}	catch(Exception ex) {
			System.out.println(ex);
		}    
        return acc;
        
	}
	
	
	public static List<Customer> getAll() {
		String email = customer_email;
		System.out.print("tgk jadi tak" + customer_email);
		List<Customer> account = new ArrayList<Customer>();
		String sql = "select * from customer where customer_email='" + customer_email + "'";
		Statement stmt = null;
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Customer acc = new Customer();
				acc.setCustomer_name(rs.getString("customer_name"));
				acc.setCustomer_email(rs.getString("customer_email"));
				acc.setCustomer_password(rs.getString("customer_password"));
				acc.setCustomer_phonenum(rs.getString("customer_phonenum"));
				acc.setCustomer_address(rs.getString("customer_address"));
				account.add(acc);
			}
		}	catch(Exception ex) {
			System.out.println(ex);
		}      
        return account;
	}
	
	
}

