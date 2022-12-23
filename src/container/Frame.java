package container;

import javax.swing.*;
import java.sql.*;
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
		JMenuItem menuTraCuuTheoMaSo = new JMenuItem("Tra cứu theo mã số");
		menuTraCuuTheoMaSo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				traCuu = new TraCuu(TraCuu.TYPE.TheoMaSo);
				screenPanel.add(traCuu, "traCuu");
				((CardLayout) screenPanel.getLayout()).show(screenPanel, "traCuu");
			}
			
		});
		JMenu menuTraCuu = new JMenu("Tra Cứu");
		menuTraCuu.add(menuTraCuuTheoMaSo);
		menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(800,30));
		menuBar.add(menuTraCuu);
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(logOutButton);
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
