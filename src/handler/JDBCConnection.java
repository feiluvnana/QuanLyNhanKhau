package handler;

import java.sql.*;
import storage.URL;

/**
 * Class hỗ trợ thiết lập kết nối với csdl
 */
public class JDBCConnection {
	/**
	 * Hàm nhận url của csdl, tài khoản và mật khẩu để tạo kết nối với csdl
	 * @param url
	 * @param username
	 * @param password
	 * @return Connection
	 */
	public Connection getConnection(String url, String username, String password) {
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
