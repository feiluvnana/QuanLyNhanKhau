package container;

import javax.swing.*;
import handler.ResultToTable;
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
		screenPanel.add("loginpage", loginPage);
		
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
				Frame ljf = new Frame();
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
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					screenPanel.add("loggedinpageadmin", loggedInPageAdmin);
					((CardLayout) screenPanel.getLayout()).show(screenPanel, "loggedinpageadmin");
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
					screenPanel.add("loginpage", loginPage);
					((CardLayout) screenPanel.getLayout()).show(screenPanel, "loginpage");
				}
			}
		});
	}
}
