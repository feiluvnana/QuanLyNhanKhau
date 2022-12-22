package container;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame{
	public JPanel screenPanel;
	LoggedInPageAdmin loggedInPageAdmin;
	LoginPage loginPage;
	
	public Frame()
	{				
		super();
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		loginPageInit();
		
		screenPanel = new JPanel();
		screenPanel.setPreferredSize(new Dimension(800,600));;
		screenPanel.setLayout(new CardLayout());
		screenPanel.add("loginPage", loginPage);
		
		this.add(screenPanel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread() {
			public void run() {
				Frame f = new Frame();
			}
		};
		thread.start();
	}
	
	public void loginPageInit() {
		loginPage = new LoginPage();
		loginPage.getConfirmedLogIn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == loginPage.getConfirmedLogIn()) {
					try {
						loggedInPageAdminInit();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					screenPanel.add("loggedInPageAdmin", loggedInPageAdmin);
					((CardLayout) screenPanel.getLayout()).show(screenPanel, "loggedInPageAdmin");
				}
			}
		});
	}
	
	public void loggedInPageAdminInit() throws SQLException {
		loggedInPageAdmin = new LoggedInPageAdmin();
		loggedInPageAdmin.getConfirmedLogOut().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == loggedInPageAdmin.getConfirmedLogOut()) {
					loginPageInit();
					screenPanel.add("loginPage", loginPage);
					((CardLayout) screenPanel.getLayout()).show(screenPanel, "loginPage");
				}
			}
		});
	}
}
