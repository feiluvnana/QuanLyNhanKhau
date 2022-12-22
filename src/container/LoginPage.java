package container;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JPanel {
	private JButton loginButton;
	private JCheckBox showPassBox;
	private JTextField usernameField;
	private JPasswordField  passwordField;
	private JLabel titleLabel, usernameLabel, passwordLabel;
	private JPanel buttonPanel, user_passPanel;
	private String typedUsername, typedPassword;
	private JButton confirmedLogInAdmin;
	private Statement sqlstatement;
	
	public LoginPage() {
		super();
		//Clicked when logged in
		confirmedLogInAdmin = new JButton();
		
		//Title of login page
		titleLabel = new JLabel("LOGIN");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		
		//Username and password field
		usernameField = new JTextField();
		usernameField.setPreferredSize(new Dimension(180, 30));
		passwordField = new JPasswordField();
		passwordField.setPreferredSize(new Dimension(180, 30));
		passwordField.setEchoChar('*');
		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
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
		
		//Show password checkbox and login button
		loginButton = new JButton("Login");
		loginButton.setPreferredSize(new Dimension(180, 30));
		loginButton.setActionCommand("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typedPassword = new String(passwordField.getPassword());
				typedUsername = usernameField.getText();
				/*ResultSet rs = null;
				try {
					sqlstmt = new JDBCConnection().getConnection().createStatement();
					rs = sqlstmt.executeQuery("SELECT * FROM logininfo WHERE PASSWORD = \"" + typedPassword + "\" AND USERNAME = \"" + typedUsername + "\";");
					if(rs.next()) {
						
					}
					else
						JOptionPane.showMessageDialog(null, "Incorrect username or password!", null, JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}*/
				JOptionPane.showMessageDialog(null, "Logged in!", null, JOptionPane.INFORMATION_MESSAGE);
				confirmedLogInAdmin.doClick();
			}
		});
		showPassBox = new JCheckBox("Show password");
		showPassBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(showPassBox.isSelected())
					passwordField.setEchoChar((char) 0);
				else
					passwordField.setEchoChar('*');
			}		
		});
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0; gbc.gridy = 0;  gbc.anchor = GridBagConstraints.WEST;
		buttonPanel.add(showPassBox, gbc);
		gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.CENTER;
		buttonPanel.add(loginButton, gbc);
		
		this.setLayout(new GridLayout(5,1));
		this.add(new JPanel());
		this.add(titleLabel);
		this.add(user_passPanel);
		this.add(buttonPanel);
		this.add(new JPanel());
	}
	
	public JButton getConfirmedLogIn() {
		return confirmedLogInAdmin;
	}
}
