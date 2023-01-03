package container;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.formdev.flatlaf.*;
import feature.*;

public class Frame extends JFrame{
	JPanel screenPanel;
	LoginPage loginPage;					
	JMenuBar menuBar;
	TraCuu traCuu;
	BienDoi bienDoi;
	ThongKe thongKe;
	TamTru tamTru;
	
	public Frame()
	{				
		super();
		//Thiết lập LookAndFeel
		try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (Exception e) {
			e.printStackTrace();
		}
		UIManager.put("OptionPane.yesButtonText", "Có");
		UIManager.put("OptionPane.noButtonText", "Không");

		//MenuBar
		menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(800,30));
		//Menu and Item for MenuBar
			//Menu Tra Cứu
			JMenu menuTraCuu = new JMenu("Tra Cứu");
				//Item for Tra Cứu
				JMenuItem menuTraCuuTheoMaSo = new JMenuItem("Tra cứu theo mã số");
				menuTraCuu.add(menuTraCuuTheoMaSo);
				menuTraCuuTheoMaSo.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						traCuu = new TraCuu(TraCuu.TYPE.TheoMaSo);
						screenPanel.add(traCuu, "traCuu");
						((CardLayout) screenPanel.getLayout()).show(screenPanel, "traCuu");
					}
				});
				//End Item for Tra Cứu
			menuBar.add(menuTraCuu);
		
			//Menu Biến Đổi
			JMenu menuBienDoi = new JMenu("HĐ Biến Đổi");
				//Item for Biến Đổi
				JMenuItem menuThemNhanKhau = new JMenuItem("Thêm nhân khẩu");
				menuBienDoi.add(menuThemNhanKhau);
				menuThemNhanKhau.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						bienDoi = new BienDoi(BienDoi.TYPE.Them);
						screenPanel.add(bienDoi, "bienDoi");
						((CardLayout) screenPanel.getLayout()).show(screenPanel, "bienDoi");	
					}
				});
				JMenuItem menuLoaiNhanKhau = new JMenuItem("Loại nhân khẩu");
				menuBienDoi.add(menuLoaiNhanKhau);
				JMenuItem menuTachHoKhau = new JMenuItem("Tách hộ khẩu");
				menuBienDoi.add(menuTachHoKhau);
				JMenuItem menuXoaNhanKhau = new JMenuItem("Xóa nhân khẩu");
				menuBienDoi.add(menuXoaNhanKhau);
				JMenuItem menuDoiChuHo = new JMenuItem("Đổi chủ hộ");
				menuBienDoi.add(menuDoiChuHo);
				//End item for Biến Đổi
			menuBar.add(menuBienDoi);
	
			//Menu Cấp Giấy
			JMenu menuCapGiay = new JMenu("Cấp Giấy");
				//Item for Cấp Giấy
				JMenuItem menuCapGiayTamTru = new JMenuItem("Cấp giấy tạm trú");
				menuCapGiay.add(menuCapGiayTamTru);
				menuCapGiayTamTru.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						tamTru = new TamTru();
						screenPanel.add(tamTru, "tamTru");
						((CardLayout) screenPanel.getLayout()).show(screenPanel, "tamTru");
					}
				});
				JMenuItem menuCapGiayTamVang = new JMenuItem("Cấp giấy tạm vắng");
				menuCapGiay.add(menuCapGiayTamVang);
				//End Item for Cấp Giấy
			menuBar.add(menuCapGiay);

			//Menu Thống Kê
			JMenu menuThongKe = new JMenu("Thống Kê");
			
				//Item for Thống Kê
				//End Item for Thống Kê
			menuBar.add(menuThongKe);
			
			//Nút đăng xuất
			menuBar.add(Box.createHorizontalGlue());
			JButton logOutButton = new JButton("Đăng xuất");
			logOutButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(getRootPane(), "Bạn có chắc muốn đăng xuất?", "Đăng xuất", JOptionPane.YES_NO_OPTION);
        			if (result == JOptionPane.YES_OPTION) {
						((CardLayout) screenPanel.getLayout()).show(screenPanel, "loginPage");
						getRootPane().setJMenuBar(null);
					}
				}		
			});
			menuBar.add(logOutButton);
		//End Menu and Item for menuBar

		loginPageInit();

		//Thiết lập screenPanel
		screenPanel = new JPanel();
		screenPanel.setPreferredSize(new Dimension(800,600));
		screenPanel.setLayout(new CardLayout());
		screenPanel.add("loginPage", loginPage);
		screenPanel.add("blank", new JPanel());
		
		//Thiết lập frame, thêm các panel cần thiết vào
		this.add(screenPanel);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
        		JFrame closingFrame = (JFrame)e.getSource();
				int result = JOptionPane.showConfirmDialog((JFrame)e.getSource(), "Bạn có chắc muốn thoát ứng dụng?", "Thoát", JOptionPane.YES_NO_OPTION);
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
				((CardLayout) screenPanel.getLayout()).show(screenPanel, "blank");
				getRootPane().setJMenuBar(menuBar);
			}
		});
	}
}
