package admin.dao;

import java.sql.*;
import java.util.*;
import connection.ConnectionManager;
import admin.model.Admin;

public class AdminDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String admin_name, admin_password, admin_username;
	static int admin_id;
	//method for login
	public static Admin login(Admin bean){
	 //get email and password
	 admin_name = bean.getAdmin_name();
	 admin_password = bean.getAdmin_password();
	 admin_username = bean.getAdmin_username();
	 String query = "select * from admin where admin_username='" + admin_username + "'AND admin_password='" + admin_password + "'";
	 try {
	 currentCon = ConnectionManager.getConnection();
	 stmt = currentCon.createStatement();
	 rs = stmt.executeQuery(query);
	 boolean more = rs.next();
	 // if user exists set the isValid variable to true
	 if (more) {
	 String admin_name = rs.getString("admin_name");
	 bean.setAdmin_name(admin_name);
	 bean.setAdmin_id(rs.getInt("admin_id"));
	 bean.setAdmin_username(rs.getString("admin_username"));
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
	public void add1(Admin bean){
		 admin_name = bean.getAdmin_name();
		 admin_password = bean.getAdmin_password();
		 admin_username = bean.getAdmin_username();
		 try {
		 //create connection
		 currentCon = ConnectionManager.getConnection();
		 //create statement
		 ps=currentCon.prepareStatement("insert into admin(admin_name,admin_password, admin_username)values(?,?,?)");
		 ps.setString(1,admin_name);
		 ps.setString(2,admin_password);
		 ps.setString(3, admin_username);
		 //execute statement
		 ps.executeUpdate();
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		}
	public static Admin getAdmin(Admin bean) {
		 //get email
		 admin_username = bean.getAdmin_username();
		 String searchQuery = "select * from admin where admin_username='" + admin_username + "'";
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
				String admin_username = rs.getString("admin_username");
				bean.setAdmin_username(admin_username);
				bean.setValid(true);
			}
			// if user does not exist set the isValid variable to false
			else if (!more) {
				bean.setValid(false);
			}
		 }	 catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return bean;
	}
	
	public static Admin getAdminU(Admin bean) {
		 //get email
		 admin_username = bean.getAdmin_username();
		 admin_id = bean.getAdmin_id();
		 String searchQuery = "select * from admin where admin_username='" + admin_username + "' and admin_id != '" + admin_id + "'";
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
		 }	catch (SQLException e) {
			 	e.printStackTrace();
		 }
		 return bean;
	}
	
	public static List<Admin> getAll() {
		List<Admin> AdminList = new ArrayList<Admin>();
		String searchQuery = "select * from admin order by admin_id";
		Statement stmt = null;
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery(searchQuery);
			while(rs.next()) {
				Admin ad = new Admin();
				ad.setAdmin_id(rs.getInt("admin_id"));
				ad.setAdmin_name(rs.getString("admin_name"));
				ad.setAdmin_username(rs.getString("admin_username"));
				ad.setAdmin_password(rs.getString("admin_password"));

				AdminList.add(ad);
			}
		}	catch(Exception ex) {
			System.out.println(ex);
		}      
        return AdminList;
	}
	public static boolean deleteAdmin(int admin_id) {
		try {
			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement("delete from admin where admin_id=?");
			ps.setInt(1, admin_id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static Admin getAccountById(int admin_id) {
		Admin pb = new Admin();
		
		try {
			currentCon = ConnectionManager.getConnection();
			String sql = "select * from admin where admin_id=?";
			ps = currentCon.prepareStatement(sql);
			ps.setInt(1, admin_id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				pb.setAdmin_id(rs.getInt("admin_id"));
				pb.setAdmin_name(rs.getString("admin_name"));
				pb.setAdmin_username(rs.getString("admin_username"));
				pb.setAdmin_password(rs.getString("admin_password"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return pb;
	}
	public static void updateAccount(Admin bean) {
		admin_name = bean.getAdmin_name();
		admin_username = bean.getAdmin_username();
		admin_password = bean.getAdmin_password();
		admin_id = bean.getAdmin_id();

		try {
			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement("update admin set admin_name=?, admin_password=?, admin_username=? where admin_id=?");
			ps.setString(1, admin_name);
			ps.setString(2, admin_password);
			ps.setString(3, admin_username);
			ps.setInt(4, admin_id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
}
