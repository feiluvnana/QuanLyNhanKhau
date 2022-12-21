package handler;

import java.sql.*;

public class JDBCConnection {
	public Connection getConnection() {
		final String url = "jdbc:mysql://localhost:3306/loginInfo";
		final String username = "root";
		final String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
