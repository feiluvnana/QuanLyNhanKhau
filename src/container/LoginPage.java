package container;

import javax.swing.*;
import handler.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JPanel {
	private JButton loginButton;								//Nút đăng nhập
	private JCheckBox showPassBox;								//Nút hiển thị mật khẩu
	private JTextField usernameField;							//Ô nhập tài khoản
	private JPasswordField  passwordField;						//Ô nhập mật khẩu
	private JLabel titleLabel, usernameLabel, passwordLabel;	//Nhãn cho tiêu đề của trang, cho "tài khoản" và "mật khẩu"
	private JPanel buttonPanel, user_passPanel;					//Panel chứa các nút ấn, và chứa các ô nhập thông tin
	private String typedUsername, typedPassword;				//Xâu để lấy thông tin đã nhập
	private JButton confirmedLogInAdmin;						//Nút xác nhận đăng nhập để ra hiệu cho Frame chuyển trang
	
	public LoginPage() {
		super();

		confirmedLogInAdmin = new JButton();
		
		//Thiết lập tiêu đề trang
		titleLabel = new JLabel("LOGIN");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		//Thiết lập ô nhập tài khoản
		usernameField = new JTextField();
		usernameField.setPreferredSize(new Dimension(180, 30));
		//Thiết lập ô nhập mật khẩu
		passwordField = new JPasswordField();
		passwordField.setPreferredSize(new Dimension(180, 30));
		passwordField.setEchoChar('*');
		//Thiết lập nhãn tài khoản
		usernameLabel = new JLabel("Username:");
		//Thiết lập nhãn mật khẩu
		passwordLabel = new JLabel("Password:");
		//Cho các ô nhập thông tin và nhãn vào user_passPanel, sắp xếp bằng GridBagLayout
		user_passPanel = new JPanel();
		user_passPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,5,5,5);
		gbc.gridx = 0; gbc.gridy = 0;
		user_passPanel.add(usernameLabel, gbc);
		gbc.gridx = 0; gbc.gridy = 1;
		user_passPanel.add(passwordLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 0;
		user_passPanel.add(usernameField, gbc);
		gbc.gridx = 1; gbc.gridy = 1;
		user_passPanel.add(passwordField, gbc);
		user_passPanel.setBackground(Color.gray);
		//Khởi tạo nút đăng nhập
		loginButton = new JButton("Login");
		loginButton.setPreferredSize(new Dimension(180, 30));
		loginButton.setActionCommand("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Khi nút đăng nhập được ấn, lấy tài khoản và mật khẩu từ ô
				typedPassword = new String(passwordField.getPassword());
				typedUsername = usernameField.getText();
				//Truy vấn kết quả trong csdl, nếu tìm thấy thì cho phép đăng nhập
				ResultSet rs = null;
				try {
					Connection conn = new JDBCConnection().getConnection(storage.URL.DB_URL, storage.URL.DB_USER, storage.URL.DB_PASS);
					PreparedStatement pstatement = conn.prepareStatement("SELECT * FROM loginInfo WHERE password = ? AND username = ?;");
					pstatement.setString(1, typedPassword);
					pstatement.setString(2, typedUsername);
					rs = pstatement.executeQuery();
					if(!rs.next()) {
						JOptionPane.showMessageDialog(null, "Logged in!", null, JOptionPane.INFORMATION_MESSAGE);
						confirmedLogInAdmin.doClick();
					}
					else
						JOptionPane.showMessageDialog(null, "Incorrect username or password!", null, JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		//Khởi tạo nút hiện mật khẩu
		showPassBox = new JCheckBox("Show password");
		showPassBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(showPassBox.isSelected())
					passwordField.setEchoChar((char) 0);
				else
					passwordField.setEchoChar('*');
			}		
		});
		//Cho các nút vào buttonPanel, sắp xếp bằng GridBagLayout
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
		buttonPanel.add(showPassBox, gbc);
		gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.CENTER;
		buttonPanel.add(loginButton, gbc);
		
		//Cho các panel vào trang đăng nhập LoginPage, sắp xếp bằng GridLayout
		this.setLayout(new GridLayout(5,1));
		this.add(new JPanel());
		this.add(titleLabel);
		this.add(user_passPanel);
		this.add(buttonPanel);
		this.add(new JPanel());
	}
	
	/**
	 * Hàm trả về nút xác nhận đăng nhập cho Frame
	 * @return confirmedLogInAdmin
	 */
	public JButton getConfirmedLogIn() {
		return confirmedLogInAdmin;
	}
}
