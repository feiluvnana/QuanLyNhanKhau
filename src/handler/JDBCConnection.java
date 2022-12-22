package handler;

import java.sql.*;
import storage.URL;

public class JDBCConnection {
	public Connection getConnection() {
		final String url = URL.QLNK_DB_URL;
		final String username = "sa";
		final String password = "1234567890";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
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
