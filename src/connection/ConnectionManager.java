package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionManager {
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/ketupatdb";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";
	private static Connection con = null;

	public static Connection getConnection() {		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return con;
	}
}

