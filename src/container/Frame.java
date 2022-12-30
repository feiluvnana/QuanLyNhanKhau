package container;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.formdev.flatlaf.*;

import feature.TraCuu;

public class Frame extends JFrame{
	Frame frame;
	public JPanel screenPanel;				//Panel để hiện toàn bộ các nội dung trong ứng dụng
	LoginPage loginPage;					//Panel để hiện cửa sổ đăng nhập
	JMenuBar menuBar;

	TraCuu traCuu;
	
	public Frame()
	{				
		super();
		//Thiết lập LookAndFeel
		try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (Exception e) {
			e.printStackTrace();
		}

		
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

		//MenuBar
		menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(800,30));
		//Menu and Item for MenuBar
			//Menu Tra Cứu
			JMenu menuTraCuu = new JMenu("Tra Cứu");
			menuBar.add(menuTraCuu);
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
		
			//Menu Biến Đổi
			JMenu menuBienDoi = new JMenu("HĐ Biến Đổi");
			menuBar.add(menuBienDoi);
			//Item and menu for Biến Đổi
				//Menu ThemNhanKhau
				JMenu menuThemNhanKhau = new JMenu("Thêm nhân khẩu");
				menuBienDoi.add(menuThemNhanKhau);
					//Item for ThemNhanKhau
					JMenuItem menuTamTru = new JMenuItem("Tạm trú");
					menuThemNhanKhau.add(menuTamTru);
					JMenuItem menuRaDoi = new JMenuItem("Mới ra đời");
					menuThemNhanKhau.add(menuTamTru);
					JMenuItem menuChuyenToi = new JMenuItem("Chuyển tới");
					menuThemNhanKhau.add(menuTamTru);
					//End item for ThemNhanKhau
				//Menu LoaiNhanKhau
				JMenu menuLoaiNhanKhau = new JMenu("Loại nhân khẩu");
				menuBienDoi.add(menuLoaiNhanKhau);
					//Item for LoaiNhanKhau
					JMenuItem menuTamVang = new JMenuItem("Tạm vắng");
					menuLoaiNhanKhau.add(menuTamVang);
					JMenuItem menuChuyenDi = new JMenuItem("Chuyển đi");
					menuLoaiNhanKhau.add(menuChuyenDi);
					JMenuItem menuQuaDoi = new JMenuItem("Qua đời");
					menuLoaiNhanKhau.add(menuChuyenDi);
					//End item for LoaiNhanKhau
				JMenuItem menuTachHoKhau = new JMenuItem("Tách hộ khẩu");
				menuBienDoi.add(menuTachHoKhau);
				JMenuItem menuXoaNhanKhau = new JMenuItem("Xóa nhân khẩu");
				menuBienDoi.add(menuXoaNhanKhau);
				JMenuItem menuDoiChuHo = new JMenuItem("Đổi chủ hộ");
				menuBienDoi.add(menuDoiChuHo);
			//End item and menu for Biến Đổi
	
		//Menu Cấp Giấy
		JMenu menuCapGiay = new JMenu("Cấp Giấy");
		menuBar.add(menuCapGiay);
			//Item for Cấp Giấy
			JMenuItem menuCapGiayTamTru = new JMenuItem("Cấp giấy tạm trú");
			menuCapGiay.add(menuCapGiayTamTru);
			JMenuItem menuCapGiayTamVang = new JMenuItem("Cấp giấy tạm vắng");
			menuCapGiay.add(menuCapGiayTamVang);
			//End Item for Cấp Giấy

		
		//Menu Thống Kê
		JMenu menuThongKe = new JMenu("Thống Kê");
		menuBar.add(menuThongKe);
			//Item for Thống Kê
			//End Item for Thống Kê
		
		loginPageInit();
		//Thiết lập screenPanel
		screenPanel = new JPanel();
		screenPanel.setPreferredSize(new Dimension(800,600));
		screenPanel.setLayout(new CardLayout());
		screenPanel.add("loginPage", loginPage);
		screenPanel.add("blank", new JPanel());
		
		//Thêm screenPanel vào frame, thiết lập frame
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
