package container;

import javax.swing.*;
import handler.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JPanel {
	
	JButton confirmedLogInButton;

	public LoginPage() {
		super();

		confirmedLogInButton = new JButton();
		
		//Thiết lập tiêu đề trang
		JLabel titleLabel = new JLabel("ĐĂNG NHẬP");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		
		//Cho các ô nhập thông tin và nhãn vào user_passPanel, sắp xếp bằng GridBagLayout
		JPanel user_passPanel = new JPanel();	
		user_passPanel.setBackground(Color.gray);
		user_passPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,5,5,5);
			//Các component của user_passPanel
			JLabel usernameLabel = new JLabel("Username:");
			gbc.gridx = 0; gbc.gridy = 0; user_passPanel.add(usernameLabel, gbc);
			JLabel passwordLabel = new JLabel("Password:");
			gbc.gridx = 0; gbc.gridy = 1; user_passPanel.add(passwordLabel, gbc);
			JTextField usernameField = new JTextField();
			usernameField.setPreferredSize(new Dimension(180, 30));
			gbc.gridx = 1; gbc.gridy = 0; user_passPanel.add(usernameField, gbc);
			JPasswordField passwordField = new JPasswordField();
			passwordField.setPreferredSize(new Dimension(180, 30));
			passwordField.setEchoChar('*');
			gbc.gridx = 1; gbc.gridy = 1; user_passPanel.add(passwordField, gbc);
			//End các component của user_passPanel
		
		//Cho các nút vào buttonPanel, sắp xếp bằng GridBagLayout
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
			//Các component của buttonPanel
			JCheckBox showPassBox = new JCheckBox("Show password");
			showPassBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(showPassBox.isSelected())
						passwordField.setEchoChar((char) 0);
					else
						passwordField.setEchoChar('*');
				}		
			});
			gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST; buttonPanel.add(showPassBox, gbc);
			JButton loginButton = new JButton("Login");
			loginButton.setPreferredSize(new Dimension(180, 30));
			loginButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Truy vấn kết quả trong csdl, nếu tìm thấy thì cho phép đăng nhập
					confirmedLogInButton.doClick();
					/*ResultSet rs = null;
					try {
						Connection conn = new JDBCConnection().getConnection(storage.URL.DB_URL, storage.URL.DB_USER, storage.URL.DB_PASS);
						PreparedStatement pstatement = conn.prepareStatement("SELECT * FROM loginInfo WHERE password = ? AND username = ?;");
						pstatement.setString(1, new String(passwordField.getPassword()));
						pstatement.setString(2, usernameField.getText());
						rs = pstatement.executeQuery();
						if(!rs.next()) {
							JOptionPane.showMessageDialog(null, "Đã đăng nhập!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
							confirmedLogInButton.doClick();
						} else
							JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu!", "Thông báo", JOptionPane.ERROR_MESSAGE);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}*/
				}
			});
			gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.CENTER; buttonPanel.add(loginButton, gbc);
			//End các component của buttonPanel
		
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
		return confirmedLogInButton;
	}
}
