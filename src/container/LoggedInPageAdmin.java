package container;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import feature.*;

public class LoggedInPageAdmin extends JPanel{
	private TraCuu traCuu;												//Cửa sổ tra cứu						
	//private ThayDoi thayDoi;											//Cửa sổ thay đổi hộ khẩu
	//private CapGiay capGiay;											//Cửa sổ cấp giấy
	private JButton logOutButton, confirmedLogOut, 						//Các nút đăng xuất, xác nhận đăng xuất (ra hiệu cho Frame)
	nutTraCuu, nutThayDoi, nutCapGiay, nutThongKe, backButton;			//Nút chọn tính năng và nút quay lại
	private JPanel logOutPanel, screenPanel, featurePanel, backPanel;	//Panel cho nút đăng xuất, panel chứa featurePanel và các Panel tính năng
																		//Panel cho các nút tính năng, panel chứa nút quay lại menu
	
	public LoggedInPageAdmin() throws SQLException {
		super();   
		
		traCuu = new TraCuu();
		thayDoi = new ThayDoi();
		confirmedLogOut = new JButton();
		//Thiết lập nút chọn tính năng tra cứu
		nutTraCuu = new JButton("Tra Cứu"); 
		nutTraCuu.setPreferredSize(new Dimension(150,50));
		nutTraCuu.setFont(new Font("Arial", Font.BOLD, 20));
		nutTraCuu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Khi ấn nút tra cứu, vào tính năng tra cứu
				backButton.setVisible(true);
				((CardLayout) screenPanel.getLayout()).show(screenPanel, "Tra Cứu");
			}
		});
		//Thiết lập nút chọn tính năng thay đổi
		nutThayDoi = new JButton("Thay Đổi"); 
		nutThayDoi.setPreferredSize(new Dimension(150,50));
		nutThayDoi.setFont(new Font("Arial", Font.BOLD, 20));
		//Thiết lập nút chọn tính năng cấp giấy
		nutCapGiay = new JButton("Cấp Giấy");
		nutCapGiay.setPreferredSize(new Dimension(150,50));
		nutCapGiay.setFont(new Font("Arial", Font.BOLD, 20));
		//Thiết lập nút chọn tính năng thống kê
		nutThongKe = new JButton("Thống Kê");
		nutThongKe.setPreferredSize(new Dimension(150,50));
		nutThongKe.setFont(new Font("Arial", Font.BOLD, 20));
		//Thêm 4 nút tính năng vào featurePanel, sắp xếp bằng GridBagLayout
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
		//Thêm featurePanel và các panel tính năng vào screenPanel, sắp xếp bằng CardLayout
		screenPanel = new JPanel();
		screenPanel.setLayout(new CardLayout());
		screenPanel.add("Chọn", featurePanel);
		screenPanel.add("Tra Cứu", traCuu);
		//Thiết lập nút đăng xuất
		logOutButton = new JButton("Log out");
		logOutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Khi nút đăng xuất được ấn, ấn nút xác nhận đăng xuất và ra hiệu cho Frame
				if(JOptionPane.showConfirmDialog(null, "Log out?", null, JOptionPane.YES_NO_OPTION) == 0)
					confirmedLogOut.doClick();
			}	
		});
		//Cho nút đăng xuất vào panel của nó
		logOutPanel = new JPanel();
		logOutPanel.setLayout(new BorderLayout());
		logOutPanel.add(logOutButton, BorderLayout.EAST);
		//Thiết lập nút quay lại
		backButton = new JButton("Back to Menu");
		backButton.setVisible(false);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Khi nút quay lại menu được ấn, quay lại giao diện chọn tính năng và reset các cửa sổ tính năng
				backButton.setVisible(false);
				((CardLayout) screenPanel.getLayout()).show(screenPanel, "Chọn");
				traCuu = new TraCuu();
				thayDoi = new ThayDoi();
				screenPanel.add("Tra Cứu", traCuu);
			}
		});
		//Thêm nút quay lại vào panel của nó
		backPanel = new JPanel();
		backPanel.setLayout(new BorderLayout());
		backPanel.add(backButton, BorderLayout.WEST);		
		//Thêm các panel vào panel tổng (loggedInPage)
		this.setLayout(new BorderLayout());
		this.add(screenPanel, BorderLayout.CENTER);
		this.add(logOutPanel, BorderLayout.SOUTH);
		this.add(backPanel, BorderLayout.NORTH);
		this.requestFocus();
	}
	
	/**
	 * Hàm trả về nút xác nhận đăng xuất, để ra hiệu cho Frame
	 * @return confirmedLogOut
	 */
	public JButton getConfirmedLogOut() {
		return confirmedLogOut;
	}
}
