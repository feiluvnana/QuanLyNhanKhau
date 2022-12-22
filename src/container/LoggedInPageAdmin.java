package container;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import feature.*;

public class LoggedInPageAdmin extends JPanel{
	private TraCuu traCuu;
	private ThayDoi thayDoi;
	private CapGiay capGiay;
	private JButton logOutButton, confirmedLogOut, nutTraCuu, nutThayDoi, nutCapGiay, nutThongKe, backButton;
	private JPanel logOutPanel, screenPanel, featurePanel, backPanel;
	
	public LoggedInPageAdmin() throws SQLException {
		super();   
		
		traCuu = new TraCuu();
		
		thayDoi = new ThayDoi();
		
		confirmedLogOut = new JButton();
		
		nutTraCuu = new JButton("Tra Cứu"); 
		nutTraCuu.setPreferredSize(new Dimension(150,50));
		nutTraCuu.setFont(new Font("Arial", Font.BOLD, 20));
		nutTraCuu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				backButton.setVisible(true);
				((CardLayout) screenPanel.getLayout()).show(screenPanel, "Tra Cứu");
			}
		});
		nutThayDoi = new JButton("Thay Đổi"); 
		nutThayDoi.setPreferredSize(new Dimension(150,50));
		nutThayDoi.setFont(new Font("Arial", Font.BOLD, 20));
		nutCapGiay = new JButton("Cấp Giấy");
		nutCapGiay.setPreferredSize(new Dimension(150,50));
		nutCapGiay.setFont(new Font("Arial", Font.BOLD, 20));
		nutThongKe = new JButton("Thống Kê");
		nutThongKe.setPreferredSize(new Dimension(150,50));
		nutThongKe.setFont(new Font("Arial", Font.BOLD, 20));
		featurePanel = new JPanel();
		featurePanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,10,10,10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0; gbc.gridy = 0;
		featurePanel.add(nutTraCuu, gbc);
		gbc.gridx = 0; gbc.gridy = 1;
		featurePanel.add(nutThayDoi, gbc);
		gbc.gridx = 0; gbc.gridy = 2;
		featurePanel.add(nutCapGiay, gbc);
		gbc.gridx = 0; gbc.gridy = 3;
		featurePanel.add(nutThongKe, gbc);
		screenPanel = new JPanel();
		screenPanel.setLayout(new CardLayout());
		screenPanel.add("Chọn", featurePanel);
		screenPanel.add("Tra Cứu", traCuu);
		
		logOutButton = new JButton("Log out");
		logOutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Log out?", null, JOptionPane.YES_NO_OPTION) == 0)
					confirmedLogOut.doClick();
			}	
		});
		logOutPanel = new JPanel();
		logOutPanel.setLayout(new BorderLayout());
		logOutPanel.add(logOutButton, BorderLayout.EAST);
		
		backButton = new JButton("Back to Menu");
		backButton.setVisible(false);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				backButton.setVisible(false);
				((CardLayout) screenPanel.getLayout()).show(screenPanel, "Chọn");
			}
		});
		backPanel = new JPanel();
		backPanel.setLayout(new BorderLayout());
		backPanel.add(backButton, BorderLayout.WEST);		
		
		this.setLayout(new BorderLayout());
		this.add(screenPanel, BorderLayout.CENTER);
		this.add(logOutPanel, BorderLayout.SOUTH);
		this.add(backPanel, BorderLayout.NORTH);
		this.requestFocus();
	}
	
	public JButton getConfirmedLogOut() {
		return confirmedLogOut;
	}
}
