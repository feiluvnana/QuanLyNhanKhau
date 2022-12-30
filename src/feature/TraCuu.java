package feature;

import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import handler.*;

public class TraCuu extends JPanel {
	public static enum TYPE {TheoMaSo};
	
	public TraCuu() {
		super();
	}
	
	public TraCuu(TYPE type) {
	if(type == TYPE.TheoMaSo) {
		//Thiết lập inputPanel, dùng GridBagLayout sắp xếp
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,10,10,10);
			//Các component của inputPanel
			JLabel titleLabel = new JLabel("Tra Cứu Hộ Khẩu");
			gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.weightx = 1; inputPanel.add(titleLabel, gbc);
			titleLabel.setHorizontalAlignment(JLabel.CENTER);
			titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
			JLabel tieuDeONhapMaSOHK = new JLabel("Mã số:");
			gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; gbc.weightx = 0.5; gbc.anchor = GridBagConstraints.EAST; inputPanel.add(tieuDeONhapMaSOHK, gbc);
			JTextField oNhapMaSoHK = new JTextField();
			gbc.gridx = 1; gbc.gridy = 1; gbc.gridwidth = 1; gbc.weightx = 0.5; gbc.anchor = GridBagConstraints.WEST; inputPanel.add(oNhapMaSoHK, gbc);
			oNhapMaSoHK.setPreferredSize(new Dimension(200, 40));
			JButton lookUpButton = new JButton("Tra Cứu");
			gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; gbc.weightx = 1; gbc.anchor = GridBagConstraints.CENTER; inputPanel.add(lookUpButton, gbc);
			lookUpButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//Khi ấn nút tra cứu, lấy mã số từ ô nhập mã số, sau đó tìm trong cơ sở dữ liệu
					String str = oNhapMaSoHK.getText();
					ResultSet rs = null;
					TraCuu traCuu = (TraCuu)((JPanel)((JButton)(e.getSource())).getParent()).getParent();
					((CardLayout) traCuu.getLayout()).show(traCuu, "lookUp");
					/*try {
						//Lấy thông tin về cửa sổ tra cứu để chuyển từ thẻ nhập liệu sang thẻ tính năng qua CardLayout
						
						TraCuu traCuu = (TraCuu)((JPanel)((JButton)(e.getSource())).getParent()).getParent();
						
						Connection conn = new JDBCConnection().getConnection(storage.URL.DB_URL, storage.URL.DB_USER, storage.URL.DB_PASS);
						PreparedStatement pstatement = conn.prepareStatement("SELECT * FROM SoHoKhau WHERE MaSoHK = ?;");
						pstatement.setString(1, str);
						rs = pstatement.executeQuery();
						if(rs.next()) {
							//Nếu đúng sẽ trả ra kết quả, đồng thời chuyển vào màn hình tính năng tra cứu
							((CardLayout) traCuu.getLayout()).show(traCuu, "lookUp");
						}
						else
							//Nếu không sẽ báo mã số sai
							JOptionPane.showMessageDialog(null, "Mã số sai!", "Thông báo", JOptionPane.ERROR_MESSAGE);		
					} catch (SQLException sqle) {
						sqle.printStackTrace();
					}*/
				}
			});
		
		//Thiết lập màn hình sau tra cứu, hiển thị sổ, dùng BorderLayOut sắp xếp
		JPanel lookupPanel = new JPanel();
		lookupPanel.setLayout(new BorderLayout());
			//Các component của lookupPanel
			Book book = new Book();
			lookupPanel.add(book, BorderLayout.CENTER);
				//Thiết lập trang cho sách
				Page title = new Page(Page.TYPE.COVER, null);
				book.addPage(title);
				Page page1 = new Page(Page.TYPE.HOUSEHOLDER, null);
				book.addPage(page1);
			JButton leftButton = new JButton("\u25c2");
			lookupPanel.add(leftButton, BorderLayout.WEST);
			leftButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					if(1 < book.getCurrentPageNum() && book.getCurrentPageNum() <= book.getNumberOfPages())
						book.showPage(book.getCurrentPageNum()-1);	
				}
			});
			JButton rightButton = new JButton("\u25b8");
			lookupPanel.add(rightButton, BorderLayout.EAST);
			rightButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					if(1 <= book.getCurrentPageNum() && book.getCurrentPageNum() < book.getNumberOfPages())
						book.showPage(book.getCurrentPageNum()+1);	
				}
			});
			//End các component của lookupPanel

		//Thêm các thẻ của panel nhập liệu và panel tính năng vào panel tổng TraCuu, sắp xếp bằng CardLayout
		this.setLayout(new CardLayout());
		this.add("input", inputPanel);
		this.add("lookUp", lookupPanel);
	}
	}
}
