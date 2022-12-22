package container;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import com.formdev.flatlaf.*;

public class Frame extends JFrame{
	public JPanel screenPanel;				//Panel để hiện toàn bộ các nội dung trong ứng dụng
	LoggedInPageAdmin loggedInPageAdmin;	//Panel để hiện toàn bộ nội dung trong khi đang trong phiên
	LoginPage loginPage;					//Panel để hiện cửa sổ đăng nhập
	
	public Frame()
	{				
		super();
		//Thiết lập LookAndFeel
		try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (Exception e) {
			e.printStackTrace();
		}

		loginPageInit();
		//Thiết lập screenPanel
		screenPanel = new JPanel();
		screenPanel.setPreferredSize(new Dimension(800,600));;
		screenPanel.setLayout(new CardLayout());
		screenPanel.add("loginPage", loginPage);
		//Thêm screenPanel vào frame, thiết lập frame
		this.add(screenPanel);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
        		JFrame closingFrame = (JFrame)e.getSource();
				int result = JOptionPane.showConfirmDialog(
					(JFrame)e.getSource(),
					"Are you sure you want to exit the application?",
					"Exit Application",
					JOptionPane.YES_NO_OPTION);
 
        		if (result == JOptionPane.YES_OPTION)
            		closingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		}
		});
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
	
	
	/**
	 * Hàm để khởi tạo loginPage
	 */
	public void loginPageInit() {
		loginPage = new LoginPage();
		loginPage.getConfirmedLogIn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Nếu nút xác nhận đăng nhập của loginPage được ấn, khởi tạo loggedInPage, sau đó chuyển màn hình sang loggedInPage
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
	
	/**
	 * Hàm để khởi tạo loggedInPage
	 */
	public void loggedInPageAdminInit() throws SQLException {
		loggedInPageAdmin = new LoggedInPageAdmin();
		loggedInPageAdmin.getConfirmedLogOut().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Nếu nút xác nhận đăng xuất của loggedInPage được ấn, khởi tạo lại loginPage, sau đó chuyển màn hình sang loginPage
				if(e.getSource() == loggedInPageAdmin.getConfirmedLogOut()) {
					loginPageInit();
					screenPanel.add("loginPage", loginPage);
					((CardLayout) screenPanel.getLayout()).show(screenPanel, "loginPage");
				}
			}
		});
	}
}
